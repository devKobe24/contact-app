package com.kobe.contact_app.service.person;

import com.kobe.contact_app.domain.person.Person;
import com.kobe.contact_app.domain.person.PersonRepository;
import com.kobe.contact_app.dto.person.request.PersonCreateRequest;
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
    public void savePerson(PersonCreateRequest request) {
        Person person = personRepository.save(new Person(request.getFirstName(), request.getLastName(), request.getPhoneNumber(), request.getEmail()));
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
}
