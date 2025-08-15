package com.example.schoolmanagement.repositories;

import com.example.schoolmanagement.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    @Query(value = "SELECT * FROM school WHERE school_name = ?1", nativeQuery = true)
    School findBySchoolNameNative(String schoolName);
}