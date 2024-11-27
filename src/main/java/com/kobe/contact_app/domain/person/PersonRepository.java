package com.kobe.contact_app.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // 이름으로 찾는 메서드.
    List<Person> findByName(String name);

    // 성으로 찾는 메서드.
    @Query("SELECT p FROM Person p WHERE p.name LIKE %:name%")
    List<Person> findByPartialName(@Param("name") String name);
}
