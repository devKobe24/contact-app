package com.kobe.contact_app.service.person;

import com.kobe.contact_app.domain.person.Person;
import com.kobe.contact_app.domain.person.PersonRepository;
import com.kobe.contact_app.dto.person.request.PersonCreateRequest;
import com.kobe.contact_app.dto.person.response.PersonDeleteEmailResponse;
import com.kobe.contact_app.dto.person.response.PersonDeletePhoneNumberResponse;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<PersonResponse> getAllContactList() {
        return personRepository.findAllByOrderByIdAsc().stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonResponse savePerson(PersonCreateRequest request) {
        Person person = personRepository.save(new Person(
                request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                request.getEmail()
        ));
        return new PersonResponse(person);
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> getPeopleByName(String name) {
        return personRepository.findByPartialName(name).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> getPeopleByPhoneNumber(String phoneNumber) {
        return personRepository.findByPhoneNumber(phoneNumber).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> getPeopleByEmail(String email) {
        return personRepository.findByEmail(email).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> getPeopleByAlphabet(String name) {
        return personRepository.findByNameAsAlphabet(name).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonResponse updateByPhoneNumber(Long id, String phoneNumber) {
        // Update 쿼리 실행.
        int updatedCount = personRepository.updateByPhoneNumber(id, phoneNumber);

        // 업데이트가 실패한 경우 예외 처리
        if (updatedCount == 0) {
            throw new IllegalArgumentException("No person found with ID: " + id);
        }

        // 업데이트된 데이터를 다시 조회
        return personRepository.findById(id)
                .map(PersonResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }

    @Transactional
    public PersonResponse updateByEmail(Long id, String email) {
        // Update 쿼리 실행
        int updatedCount = personRepository.updateByEmail(id, email);

        // 업데이트가 실패한 경우 예외 처리
        if (updatedCount == 0) {
            throw new IllegalArgumentException("No person found with ID: " + id);
        }

        // 업데이트된 데이터를 다시 조회
        return personRepository.findById(id)
                .map(PersonResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }

    @Transactional
    public PersonResponse updateByFirstName(Long id, String firstName) {
        // Update 쿼리 실행.
        int updateCount = personRepository.updateByFirstName(id, firstName);

        // 업데이트가 실패한 경우 예외 처리.
        if (updateCount == 0) {
            throw new IllegalArgumentException("No person found with ID: " + id);
        }

        // 업데이트된 데이터를 다시 조회.
        return personRepository.findById(id)
                .map(PersonResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }

    @Transactional
    public PersonResponse updateByLastName(Long id, String lastName) {
        // Update 쿼리 실행.
        int updateCount = personRepository.updateByLastName(id, lastName);

        // 업데이트가 실패한 경우 예외 처리.
        if (updateCount == 0) {
            throw new IllegalArgumentException("No person found with ID: " + id);
        }

        // 업데이트된 데이터를 다시 조회.
        return personRepository.findById(id)
                .map(PersonResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }

    @Transactional
    public PersonDeletePhoneNumberResponse deletePhoneNumber(Long id) {
        // ID로 Person 조회
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));

        // phoneNumber 삭제(NULL로 설정)
        int updatedCount = personRepository.deleteByPhoneNumber(id);

        // 업데이트가 실패한 경우 예외 처리.
        if (updatedCount == 0) {
            throw new IllegalArgumentException("Failed to delete phone number for ID: " + id);
        }

        // 업데이트 된 데이터를 다시 조회.
        return personRepository.findById(id)
                .map(PersonDeletePhoneNumberResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }

    @Transactional
    public PersonDeleteEmailResponse deleteEmail(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));

        int updatedCount = personRepository.deleteByEmail(id);

        if (updatedCount == 0) {
            throw new IllegalArgumentException("Failed to delete email for ID: " + id);
        }

        return personRepository.findById(id)
                .map(PersonDeleteEmailResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }
}
