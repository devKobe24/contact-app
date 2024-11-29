package com.kobe.contact_app.dto.person.response;

import com.kobe.contact_app.domain.person.Person;

public class PersonDeletePhoneNumberResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public PersonDeletePhoneNumberResponse(Person person) {
        this.id = person.getId();
        this.name = person.getFirstName() + " " + person.getLastName();
        this.phoneNumber = "DELETE SUCCESSFUL : " + person.getPhoneNumber();
        this.email = person.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
