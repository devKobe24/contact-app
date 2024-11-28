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
}
