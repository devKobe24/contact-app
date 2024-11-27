package com.kobe.contact_app.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // 이름으로 찾는 메서드.
    List<Person> findByName(String name);
}
