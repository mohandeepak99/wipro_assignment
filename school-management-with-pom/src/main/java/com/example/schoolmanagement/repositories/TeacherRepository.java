package com.example.schoolmanagement.repositories;

import com.example.schoolmanagement.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "SELECT * FROM teacher WHERE qualification = ?1", nativeQuery = true)
    Teacher findByQualificationNative(String qualification);
}