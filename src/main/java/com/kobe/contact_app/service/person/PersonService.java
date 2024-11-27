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
        String name = request.getLastName() + request.getFirstName();
        Person person = personRepository.save(new Person(name, request.getPhoneNumber(), request.getEmail()));
    }

    // 동명이인이 있을 수 있으므로 List 형태로.
    @Transactional(readOnly = true)
    public List<PersonResponse> getPeopleByFullName(String name) {
        return personRepository.findByName(name).stream()
                .map(PersonResponse::new)
                .collect(Collectors.toList());
    }
}
