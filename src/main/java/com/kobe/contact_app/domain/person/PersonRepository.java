package com.kobe.contact_app.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // 이름으로 사람 찾기
    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %:name% OR p.lastName LIKE %:name%")
    List<Person> findByPartialName(@Param("name") String name);

    // 번호로 사람 찾기
    @Query("SELECT p FROM Person p WHERE p.phoneNumber LIKE %:phone_number%")
    List<Person> findByPhoneNumber(@Param("phone_number") String phoneNumber);

    // 이메일로 사람 찾기
    @Query("SELECT p FROM Person p WHERE p.email LIKE %:email%")
    List<Person> findByEmail(@Param("email") String email);

    // 알파벳으로 사람 찾기
    @Query("SELECT p FROM Person p WHERE p.firstName LIKE %:name% OR p.lastName LIKE %:name%")
    List<Person> findByNameAsAlphabet(@Param("name") String name);

    // 번호 변경.
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.phoneNumber = :phoneNumber WHERE p.id = :id")
    int updateByPhoneNumber(@Param("id") Long id, @Param("phoneNumber") String phoneNumber);

    // 이메일 변경.
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.email = :email WHERE p.id = :id")
    int updateByEmail(@Param("id") Long id, @Param("email") String email);

    // 이름 변경.
    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.firstName = :firstName WHERE p.id = :id")
    int updateByFirstName(@Param("id") Long id, @Param("firstName") String firstName);
}
