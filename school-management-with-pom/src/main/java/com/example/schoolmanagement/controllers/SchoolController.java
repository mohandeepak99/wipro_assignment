package com.example.schoolmanagement.controllers;

import com.example.schoolmanagement.entities.School;
import com.example.schoolmanagement.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/addSchool")
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        return new ResponseEntity<>(schoolService.addSchool(school), HttpStatus.CREATED);
    }

    @GetMapping("/getAllSchools")
    public ResponseEntity<List<School>> getAllSchools() {
        return new ResponseEntity<>(schoolService.getAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/getSchoolById/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
    }

    @PutMapping("/updateSchoolById/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School school) {
        return new ResponseEntity<>(schoolService.updateSchoolById(id, school), HttpStatus.OK);
    }

    @PatchMapping("/patchUpdateSchoolById/{id}")
    public ResponseEntity<School> patchSchool(@PathVariable Long id, @RequestBody School school) {
        return new ResponseEntity<>(schoolService.patchUpdateSchoolById(id, school), HttpStatus.OK);
    }

    @DeleteMapping("/deleteSchoolById/{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchoolById(id);
        return new ResponseEntity<>("School deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<School> getByName(@PathVariable String name) {
        return new ResponseEntity<>(schoolService.getSchoolByName(name), HttpStatus.OK);
    }

    @GetMapping("/getTeacherByQualification/{qualification}")
    public ResponseEntity<String> getByQualification(@PathVariable String qualification) {
        return new ResponseEntity<>(schoolService.getTeacherByQualification(qualification), HttpStatus.OK);
    }
}