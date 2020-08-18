package com.alex.lms.service;


import com.alex.lms.model.Student;
import com.alex.lms.repository.StudenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudenRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @CachePut(cacheNames = "student", key = "#student.studentId")
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(cacheNames = "student", key = "#studentId")
    public Optional<Student> fetchById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @CacheEvict(cacheNames = "student", key = "#student.studentId")
    public void delete(Student student) { studentRepository.delete(student);}
}
