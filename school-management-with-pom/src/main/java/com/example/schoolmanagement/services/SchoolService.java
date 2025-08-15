package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.School;
import java.util.List;

public interface SchoolService {

    School addSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(Long id);
    School updateSchoolById(Long id, School school);
    School patchUpdateSchoolById(Long id, School school);
    void deleteSchoolById(Long id);
    School getSchoolByName(String name);
    String getTeacherByQualification(String qualification);
}