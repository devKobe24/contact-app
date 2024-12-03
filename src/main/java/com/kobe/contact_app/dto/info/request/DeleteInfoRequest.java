package com.kobe.contact_app.dto.info.request;

public class DeleteInfoRequest {
    private Long id;

    public DeleteInfoRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
