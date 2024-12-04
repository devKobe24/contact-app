package com.kobe.contact_app.controller;

import com.kobe.contact_app.dto.name.request.FirstNameDeleteRequest;
import com.kobe.contact_app.dto.name.request.LastNameDeleteRequest;
import com.kobe.contact_app.dto.name.response.FirstNameDeleteResponse;
import com.kobe.contact_app.dto.name.response.LastNameDeleteResponse;
import com.kobe.contact_app.dto.person.request.create.PersonCreateRequest;
import com.kobe.contact_app.dto.person.request.delete.PersonEmailDeleteRequest;
import com.kobe.contact_app.dto.person.request.delete.PersonPhoneNumberDeleteRequest;
import com.kobe.contact_app.dto.person.request.update.PersonEmailUpdateRequest;
import com.kobe.contact_app.dto.person.request.update.PersonFirstNameUpdateRequest;
import com.kobe.contact_app.dto.person.request.update.PersonLastNameUpdateRequest;
import com.kobe.contact_app.dto.person.request.update.PersonPhoneNumberUpdateRequest;
import com.kobe.contact_app.dto.person.response.PersonDeleteEmailResponse;
import com.kobe.contact_app.dto.person.response.PersonDeletePhoneNumberResponse;
import com.kobe.contact_app.dto.person.response.PersonResponse;
import com.kobe.contact_app.service.person.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@Tag(name = "Person", description = "Person API")
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
    @Operation(summary = "Show Contact List", description = "저장되어 있는 연락처 리스트를 전부 보여줍니다.")
    public List<PersonResponse> getAllContactList() {
        return personService.getAllContactList();
    }

    @GetMapping("/search")
    @Operation(summary = "Shows search results by last name or first name", description = "저장되이 있는 연락처 리스트를 성 또는 이름으로 검색한 결과로 보여줍니다.")
    public List<PersonResponse> getPeopleByName(@RequestParam("name") String name) {
        return personService.getPeopleByName(name);
    }

    @GetMapping("/search/phone")
    @Operation(summary = "Shows search results by phone number", description = "저장되어 있는 연락처 리스트를 전화번호로 검색한 결과로 보여줍니다.")
    public List<PersonResponse> getPeopleByPhoneNumber(@RequestParam("number") String phoneNumber) {
        return personService.getPeopleByPhoneNumber(phoneNumber);
    }

    @GetMapping("/search/email")
    @Operation(summary = "Shows search results by email", description = "저장되어 있는 연락처 리스트를 이메일로 검색한 결과로 보여줍니다.")
    public List<PersonResponse> getPeopleByEmail(@RequestParam("email") String email) {
        return personService.getPeopleByEmail(email);
    }

    @GetMapping("/search/english")
    @Operation(summary = "Shows search results by english name", description = "저장되어 있는 연락처 리스트를 영어 성 또는 영어 이름으로 검색한 결과로 보여줍니다.")
    public List<PersonResponse> getPeopleByAlphabet(@RequestParam("name") String name) {
        return personService.getPeopleByAlphabet(name);
    }

    @PutMapping("/update/number")
    @Operation(summary = "Edit/Update phone number", description = "전화번호를 수정합니다.")
    public PersonResponse updatePhoneNumber(@RequestBody PersonPhoneNumberUpdateRequest request) {
        return personService.updateByPhoneNumber(request.getId(), request.getPhoneNumber());
    }

    @PutMapping("/update/email")
    @Operation(summary = "Edit/Update email", description = "이메일을 수정합니다.")
    public PersonResponse updateEmail(@RequestBody PersonEmailUpdateRequest request) {
        return personService.updateByEmail(request.getId(), request.getEmail());
    }

    @PutMapping("/update/firstname")
    @Operation(summary = "Edit/Update first name", description = "이름을 수정합니다.")
    public PersonResponse updateFirstName(@RequestBody PersonFirstNameUpdateRequest request) {
        return personService.updateByFirstName(request.getId(), request.getFirstName());
    }

    @PutMapping("/update/lastname")
    @Operation(summary = "Edit/Update last name", description = "성을 수정합니다.")
    public PersonResponse updateLastName(@RequestBody PersonLastNameUpdateRequest request) {
        return personService.updateByLastName(request.getId(), request.getLastName());
    }

    @PutMapping("/delete/number")
    @Operation(summary = "Delete phone number", description = "전화번호를 삭제합니다.")
    public PersonDeletePhoneNumberResponse deletePhoneNumber(@RequestBody PersonPhoneNumberDeleteRequest request) {
        return personService.deletePhoneNumber(request);
    }

    @PutMapping("/delete/email")
    @Operation(summary = "Delete email", description = "이메일을 삭제합니다.")
    public PersonDeleteEmailResponse deleteEmail(@RequestBody PersonEmailDeleteRequest request) {
        return personService.deleteEmail(request.getId());
    }

    @PutMapping("/delete/firstname")
    @Operation(summary = "Delete first name", description = "이름을 삭제합니다.")
    public FirstNameDeleteResponse deleteFirstName(@RequestBody FirstNameDeleteRequest request) {
        return personService.deleteFirstName(request.getId());
    }

    @PutMapping("/delete/lastname")
    @Operation(summary = "Delete last name", description = "성을 삭제합니다.")
    public LastNameDeleteResponse deleteLastName(@RequestBody LastNameDeleteRequest request) {
        return personService.deleteLastName(request.getId());
    }
}
