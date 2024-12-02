package com.kobe.contact_app.util.name;

import com.kobe.contact_app.callback.PersonCallback;
import com.kobe.contact_app.constant.ContactState;
import com.kobe.contact_app.constant.NameState;
import com.kobe.contact_app.exception.MissingFieldException;

public class NameStateProcessor {
    private static String processNameState(NameState nameState, String firstName, String lastName, String phoneNumber, String email) {
        switch (nameState) {
            case ONLY_FIRST_NAME, BOTH_NAMES:
                return firstName;
            case ONLY_LAST_NAME:
                return null; // Last name handled separately
            case NO_NAMES:
                return phoneNumber != null ? phoneNumber : email;
            default:
                throw new MissingFieldException("Unexpected nameState: " + nameState);
        }
    }

    private static NameState determineNameState(String firstName, String lastName) {
        if (firstName != null && lastName == null) {
            return NameState.ONLY_FIRST_NAME;
        } else if (firstName == null && lastName != null) {
            return NameState.ONLY_LAST_NAME;
        } else if (firstName != null && lastName != null) {
            return NameState.BOTH_NAMES;
        } else {
            return NameState.NO_NAMES;
        }
    }

    private static ContactState determineContactState(String phoneNumber, String email) {
        if (phoneNumber != null && email == null) {
            return ContactState.ONLY_PHONE_NUMBER;
        } else if (phoneNumber == null && email != null) {
            return ContactState.ONLY_EMAIL;
        } else if (phoneNumber != null && email != null) {
            return ContactState.BOTH_CONTACT;
        } else {
            return ContactState.NO_CONTACT;
        }
    }

    public static void determineFirstNameAndLastNameState(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            PersonCallback callback) {

        NameState nameState = determineNameState(firstName, lastName);
        ContactState contactState = determineContactState(phoneNumber, email);

        if (contactState == ContactState.NO_CONTACT) {
            throw new MissingFieldException("phone number or email");
        }

        String resultFirstName = processNameState(nameState, firstName, lastName, phoneNumber, email);
        String resultLastName = nameState == NameState.ONLY_LAST_NAME || nameState == NameState.BOTH_NAMES ? lastName : null;
        String resultPhoneNumber = contactState == ContactState.ONLY_PHONE_NUMBER || contactState == ContactState.BOTH_CONTACT ? phoneNumber : null;
        String resultEmail = contactState == ContactState.ONLY_EMAIL || contactState == ContactState.BOTH_CONTACT ? email : null;


        callback.onResult(resultFirstName, resultLastName, resultPhoneNumber, resultEmail);
    }
}
