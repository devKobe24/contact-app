package com.kobe.contact_app.callback;

@FunctionalInterface
public interface PersonCallback {
    void onResult(String firstName, String lastName, String phoneNumber, String email);
}
