package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.School;
import com.example.schoolmanagement.entities.Teacher;
import com.example.schoolmanagement.repositories.SchoolRepository;
import com.example.schoolmanagement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
    }

    @Override
    public School updateSchoolById(Long id, School updated) {
        School school = getSchoolById(id);
        school.setSchoolName(updated.getSchoolName());
        school.setSchoolAdress(updated.getSchoolAdress());
        school.setTeacher(updated.getTeacher());
        return schoolRepository.save(school);
    }

    @Override
    public School patchUpdateSchoolById(Long id, School school) {
        School existing = getSchoolById(id);
        if (school.getSchoolName() != null)
            existing.setSchoolName(school.getSchoolName());
        if (school.getSchoolAdress() != null)
            existing.setSchoolAdress(school.getSchoolAdress());
        if (school.getTeacher() != null)
            existing.setTeacher(school.getTeacher());
        return schoolRepository.save(existing);
    }

    @Override
    public void deleteSchoolById(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School getSchoolByName(String name) {
        return schoolRepository.findBySchoolNameNative(name);
    }

    @Override
    public String getTeacherByQualification(String qualification) {
        Teacher teacher = teacherRepository.findByQualificationNative(qualification);
        return teacher == null ? "No teacher found" : teacher.getTeacherName();
    }
}