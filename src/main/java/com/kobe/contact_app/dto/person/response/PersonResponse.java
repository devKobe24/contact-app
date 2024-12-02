package com.kobe.contact_app.dto.person.response;

import com.kobe.contact_app.domain.person.Person;

public class PersonResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


    public PersonResponse(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phoneNumber = person.getPhoneNumber();
        this.email = person.getEmail();
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

    public String getEmail() {
        return email;
    }
}
