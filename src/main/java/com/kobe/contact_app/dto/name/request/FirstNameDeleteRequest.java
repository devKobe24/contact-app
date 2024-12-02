package com.kobe.contact_app.dto.name.request;

public class FirstNameDeleteRequest {
    private Long id;

    public FirstNameDeleteRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
