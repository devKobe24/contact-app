package com.kobe.contact_app.dto.person.request.update;

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
