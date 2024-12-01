package com.kobe.contact_app.domain.person;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String email;

    protected Person() {}

    public Person(String firstName, String lastName, String phoneNumber, String email) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException(String.format("First name cannot be null or empty"));
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException(String.format("Last name cannot be null or empty"));
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException(String.format("Phone number cannot be null or empty"));
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
