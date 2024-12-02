package com.kobe.contact_app.exception;

public class MissingFieldException extends RuntimeException {
    private final String field;

    public MissingFieldException(String field) {
        super(String.format("Missing required field '%s'", field));
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
