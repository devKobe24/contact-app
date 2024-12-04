package com.kobe.contact_app.controller;

import com.kobe.contact_app.dto.info.request.DeleteInfoRequest;
import com.kobe.contact_app.dto.name.request.FirstNameDeleteRequest;
import com.kobe.contact_app.dto.name.request.LastNameDeleteRequest;
import com.kobe.contact_app.dto.name.response.FirstNameDeleteResponse;
import com.kobe.contact_app.dto.name.response.LastNameDeleteResponse;
import com.kobe.contact_app.dto.person.request.*;
import com.kobe.contact_app.dto.person.response.PersonDeleteEmailResponse;
import com.kobe.contact_app.dto.person.response.PersonDeletePhoneNumberResponse;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import com.kobe.contact_app.service.person.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    @Operation(summary = "Save Contact", description = "이름, 성, 전화번호, 이메일을 입력하여 연락처를 저장합니다.")
    public PersonResponse savePerson(@RequestBody PersonCreateRequest request) {
        return personService.savePerson(request);
    }

    @GetMapping("/searchAll")
    public List<PersonResponse> getAllContactList() {
        return personService.getAllContactList();
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

    @PutMapping("/delete/number")
    public PersonDeletePhoneNumberResponse deletePhoneNumber(@RequestBody PersonPhoneNumberDeleteRequest request) {
        return personService.deletePhoneNumber(request.getId());
    }

    @PutMapping("/delete/email")
    public PersonDeleteEmailResponse deleteEmail(@RequestBody PersonEmailDeleteRequest request) {
        return personService.deleteEmail(request.getId());
    }

    @PutMapping("/delete/firstname")
    public FirstNameDeleteResponse deleteFirstName(@RequestBody FirstNameDeleteRequest request) {
        return personService.deleteFirstName(request.getId());
    }

    @PutMapping("/delete/lastname")
    public LastNameDeleteResponse deleteLastName(@RequestBody LastNameDeleteRequest request) {
        return personService.deleteLastName(request.getId());
    }
}
