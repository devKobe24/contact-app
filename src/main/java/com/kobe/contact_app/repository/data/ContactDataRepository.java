package com.kobe.contact_app.repository.data;

import com.kobe.contact_app.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ContactDataRepository extends JpaRepository<Person, Long> {

    // 전체 데이터 삭제.
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE person", nativeQuery = true)
    void deleteAllData();

    // 특정 연락처 정보 전체 삭제.
    @Modifying
    @Transactional
    @Query("DELETE FROM Person p WHERE p.id = :id")
    void deleteAllInfoById(@Param("id") Long id);
}
