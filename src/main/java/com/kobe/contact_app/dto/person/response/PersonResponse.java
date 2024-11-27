package com.kobe.contact_app.dto.person.response;

import com.kobe.contact_app.domain.person.Person;

public class PersonResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.phoneNumber = person.getPhoneNumber();
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
