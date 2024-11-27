package com.kobe.contact_app.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %:name% OR p.lastName LIKE %:name%")
    List<Person> findByPartialName(@Param("name") String name);
}
