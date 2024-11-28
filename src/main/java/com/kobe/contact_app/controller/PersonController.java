package com.kobe.contact_app.controller;

import com.kobe.contact_app.dto.person.request.PersonCreateRequest;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import com.kobe.contact_app.service.person.PersonService;
import org.springframework.web.bind.annotation.*;

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
    public List<PersonResponse> getPeopleByName(String name) {
        return personService.getPeopleByName(name);
    }

    @GetMapping("/search/phone")
    public List<PersonResponse> getPeopleByPhoneNumber(@RequestParam("number") String phoneNumber) {
        return personService.getPeopleByPhoneNumber(phoneNumber);
    }
}
