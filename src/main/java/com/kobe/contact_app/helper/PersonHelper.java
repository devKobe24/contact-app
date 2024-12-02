package com.kobe.contact_app.helper;

import org.springframework.data.jpa.repository.JpaRepository;

public class PersonHelper {
    public static <T> T findPersonById(Long id, JpaRepository<T, Long> repository) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No person found with id: " + id));
    }
}
