package com.kobe.contact_app.dto.name.response;

import com.kobe.contact_app.domain.person.Person;

public class FirstNameDeleteResponse {

    private Long id;
    private String firstName;
    private String message;

    public FirstNameDeleteResponse(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.message = "Successfully deleted " + person.getFirstName();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMessage() {
        return message;
    }
}
