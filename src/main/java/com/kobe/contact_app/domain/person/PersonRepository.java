package com.kobe.contact_app.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // 이름으로 찾는 메서드.
    Optional<Person> findByName(String name);
}
