package com.kobe.contact_app.dto.person.request.delete;

import io.swagger.v3.oas.annotations.media.Schema;

public class PersonPhoneNumberDeleteRequest {
    @Schema(description = "번호가 삭제 될 ID", example = "6", required = true)
    private Long id;

    @Schema(description = "삭제할 이름", example = "민성", nullable = true)
    private String firstName;

    @Schema(description = "삭제할 성", example = "강", nullable = true)
    private String lastName;

    @Schema(description = "삭제할 이메일", example = "test@example.com", nullable = true)
    private String email;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
