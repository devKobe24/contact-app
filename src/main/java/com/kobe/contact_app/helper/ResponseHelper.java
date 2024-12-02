package com.kobe.contact_app.helper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Function;

public class ResponseHelper {
    public static <E, R> R createResponse(Long id, Function<E, R> responseConstructor, JpaRepository<E, Long> repository) {
        return repository.findById(id)
                .map(responseConstructor)
                .orElseThrow(() -> new IllegalArgumentException("No person found with ID: " + id));
    }
}
