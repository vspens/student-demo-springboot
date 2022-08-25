package com.example.demo.controllers;

import ch.qos.logback.core.CoreConstants;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public List<Student> list() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        if (!studentService.isStudentExist(student.getEmail())) {
            studentService.registerStudent(student);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        if (studentService.isStudentExist(id)) {
            studentService.deleteStudentById(id);
        }
    }
}
