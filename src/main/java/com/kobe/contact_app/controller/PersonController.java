package com.kobe.contact_app.controller;

import com.kobe.contact_app.dto.person.request.PersonCreateRequest;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import com.kobe.contact_app.service.person.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public void savePerson(@RequestBody PersonCreateRequest request) {
        personService.savePerson(request);
    }

    @GetMapping("/search")
    public List<PersonResponse> getPeopleByFullName(String name) {
        return personService.getPeopleByFullName(name);
    }

    @GetMapping("/search/firstname")
    public List<PersonResponse> getPeopleByFirstName(String name) {
        return personService.getPeopleByFirstName(name);
    }
}
