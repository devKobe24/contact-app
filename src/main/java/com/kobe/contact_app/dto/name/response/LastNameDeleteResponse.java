package com.kobe.contact_app.dto.name.response;

import com.kobe.contact_app.domain.person.Person;

public class LastNameDeleteResponse {

    private Long id;
    private String lastName;
    private String message;

    public LastNameDeleteResponse(Person person) {
        this.id = person.getId();
        this.lastName = person.getLastName();
        this.message = "Successfully deleted last name: " + person.getLastName();
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMessage() {
        return message;
    }
}
