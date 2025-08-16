package com.company.controller;

import com.company.entity.StudentsFrom;
import com.company.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/submitForm")
    public RedirectView submitForm(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email
    ) {
        StudentsFrom student = new StudentsFrom();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);

        studentRepository.save(student);
        return new RedirectView("/success");
    }

    @GetMapping("/success")
    @ResponseBody
    public String successPage() {
        return "Student saved successfully!";
    }
}

