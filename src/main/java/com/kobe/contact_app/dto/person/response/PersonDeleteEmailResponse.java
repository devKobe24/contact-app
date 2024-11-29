package com.kobe.contact_app.dto.person.response;

import com.kobe.contact_app.domain.person.Person;

public class PersonDeleteEmailResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PersonDeleteEmailResponse(Person person) {
        this.id = person.getId();

        if (person.getFirstName() != null) {
            this.firstName = person.getFirstName();
        } else {
            this.firstName = null;
        }

        if (person.getLastName() != null) {
            this.lastName = person.getLastName();
        } else {
            this.lastName = null;
        }

        if (person.getPhoneNumber() != null) {
            this.phoneNumber = person.getPhoneNumber();
        } else {
            this.phoneNumber = null;
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
