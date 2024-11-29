package com.kobe.contact_app.dto.person.request;

public class PersonPhoneNumberDeleteRequest {
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
