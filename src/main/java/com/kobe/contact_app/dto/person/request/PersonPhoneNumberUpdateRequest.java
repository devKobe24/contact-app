package com.kobe.contact_app.dto.person.request;

public class PersonPhoneNumberUpdateRequest {
    private Long id;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
