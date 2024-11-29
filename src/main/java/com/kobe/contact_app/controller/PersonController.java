package com.kobe.contact_app.controller;

import com.kobe.contact_app.domain.person.Person;
import com.kobe.contact_app.dto.person.request.*;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import com.kobe.contact_app.service.person.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
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
    public List<PersonResponse> getPeopleByName(@RequestParam("name") String name) {
        return personService.getPeopleByName(name);
    }

    @GetMapping("/search/phone")
    public List<PersonResponse> getPeopleByPhoneNumber(@RequestParam("number") String phoneNumber) {
        return personService.getPeopleByPhoneNumber(phoneNumber);
    }

    @GetMapping("/search/email")
    public List<PersonResponse> getPeopleByEmail(@RequestParam("email") String email) {
        return personService.getPeopleByEmail(email);
    }

    @GetMapping("/search/english")
    public List<PersonResponse> getPeopleByAlphabet(@RequestParam("name") String name) {
        return personService.getPeopleByAlphabet(name);
    }

    @PutMapping("/update/number")
    public PersonResponse updatePhoneNumber(@RequestBody PersonPhoneNumberUpdateRequest request) {
        return personService.updateByPhoneNumber(request.getId(), request.getPhoneNumber());
    }

    @PutMapping("/update/email")
    public PersonResponse updateEmail(@RequestBody PersonEmailUpdateRequest request) {
        return personService.updateByEmail(request.getId(), request.getEmail());
    }

    @PutMapping("/update/firstname")
    public PersonResponse updateFirstName(@RequestBody PersonFirstNameUpdateRequest request) {
        return personService.updateByFirstName(request.getId(), request.getFirstName());
    }

    @PutMapping("/update/lastname")
    public PersonResponse updateLastName(@RequestBody PersonLastNameUpdateRequest request) {
        return personService.updateByLastName(request.getId(), request.getLastName());
    }

}
