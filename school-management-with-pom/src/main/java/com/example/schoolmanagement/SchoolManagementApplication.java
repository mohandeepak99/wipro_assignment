package com.example.schoolmanagement;

import com.example.schoolmanagement.entities.School;
import com.example.schoolmanagement.entities.Teacher;
import com.example.schoolmanagement.repositories.SchoolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class SchoolManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(SchoolRepository schoolRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Teacher t1 = new Teacher(null, "Narayana", "123 gwk", "PhD", 45, sdf.parse("1980-05-15"), 20);
            School s1 = new School(null, "KK school", "Gwk", t1);

            Teacher t2 = new Teacher(null, "chaitanya", "456 vzg", "MSc", 38, sdf.parse("1986-11-23"), 12);
            School s2 = new School(null, "Abc School", "Hyd", t2);

            schoolRepository.save(s1);
            schoolRepository.save(s2);
        };
    }
}