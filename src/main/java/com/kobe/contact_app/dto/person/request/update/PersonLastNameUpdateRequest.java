package com.kobe.contact_app.dto.person.request.update;

public class PersonLastNameUpdateRequest {
    private Long id;
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }
}