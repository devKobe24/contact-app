package com.kobe.contact_app.domain.person;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String email;

    protected Person() {}

    public Person(String name, String phoneNumber, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("Name cannot be null or empty"));
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException(String.format("Phone number cannot be null or empty"));
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
