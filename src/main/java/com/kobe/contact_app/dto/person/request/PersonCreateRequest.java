package com.kobe.contact_app.dto.person.request;

import com.kobe.contact_app.callback.PersonCallback;
import com.kobe.contact_app.constant.ContactState;
import com.kobe.contact_app.constant.NameState;
import com.kobe.contact_app.exception.MissingFieldException;

public class PersonCreateRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public PersonCreateRequest(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
