package com.oauth.server.controller;

import com.oauth.server.model.Student;
import com.oauth.server.model.Users;
import com.oauth.server.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private UserRepo userRepo;

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Lakshyaveer Singh", 60),
            new Student(1, "Vishakha Singh", 70)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}
