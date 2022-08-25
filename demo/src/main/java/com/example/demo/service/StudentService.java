package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final IStudentRepository iStudentRepository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public List<Student> getStudents() {
        return iStudentRepository.findAll();
    }

    public void registerStudent(Student student) {
        iStudentRepository.save(student);
    }

    public boolean isStudentExist(String email) {
        return iStudentRepository.isStudentExist(email).isPresent();
    }

    public boolean isStudentExist(Long id) {
        return iStudentRepository.existsById(id);
    }

    public void deleteStudentById(Long id) {
        iStudentRepository.deleteById(id);
    }
}
