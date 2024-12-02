package com.kobe.contact_app.dto.person.request;

import com.kobe.contact_app.util.name.NameStateProcessor;

public class PersonCreateRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public PersonCreateRequest(String firstName, String lastName, String phoneNumber, String email) {
        NameStateProcessor.determineFirstNameAndLastNameState(firstName, lastName, phoneNumber, email, (resultFirstName, resultLastName, resultPhoneNumber, resultEmail) -> {
            this.firstName = resultFirstName;
            this.lastName = resultLastName;
            this.phoneNumber = resultPhoneNumber;
            this.email = resultEmail;
        });
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
