package com.alex.lms.repository;


import com.alex.lms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenRepository extends JpaRepository<Student, Integer> {
}
