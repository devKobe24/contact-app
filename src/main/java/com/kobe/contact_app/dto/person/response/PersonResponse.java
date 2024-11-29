package com.kobe.contact_app.dto.person.response;

import com.kobe.contact_app.domain.person.Person;

public class PersonResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public PersonResponse(Person person) {
        this.id = person.getId();

        if (person.getFirstName() != null && person.getLastName() != null) {
            this.name = person.getFirstName() + " " + person.getLastName();
        } else if (person.getFirstName() != null && person.getLastName() == null) {
            this.name = person.getFirstName();
        } else if (person.getFirstName() == null && person.getLastName() != null) {
            this.name = null + " " + person.getLastName();
        } else {
            this.name = null;
        }

        if (person.getPhoneNumber() != null) {
            this.phoneNumber = person.getPhoneNumber();
        } else {
            this.phoneNumber = null;
        }

        if (person.getEmail() != null) {
            this.email = person.getEmail();
        } else {
            this.email = null;
        }


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
