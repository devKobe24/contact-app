package com.kobe.contact_app.dto.name.request;

public class LastNameDeleteRequest {
    private Long id;

    public LastNameDeleteRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
