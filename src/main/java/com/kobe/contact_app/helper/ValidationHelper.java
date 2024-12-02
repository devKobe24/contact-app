package com.kobe.contact_app.helper;

public class ValidationHelper {
    public static void validateUpdateCount(int updateCount, Long id) {
        if (updateCount == 0) {
            throw new IllegalArgumentException("Failed to delete for id " + id);
        }
    }
}
