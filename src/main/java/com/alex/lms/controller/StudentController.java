package com.alex.lms.controller;

import com.alex.lms.model.Student;
import com.alex.lms.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        log.info("Entering to create student");
        try{
            return ResponseEntity.ok().body(studentService.create(student));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        log.info("Entering to update student");
        try{
            return ResponseEntity.ok().body(studentService.create(student));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Student student) {
        log.info("Entering to delete student");
        try{
            studentService.delete(student);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> fetch(@PathVariable(value = "id") int studentId) {

        Optional<Student> student = studentService.fetchById(studentId);
        if (student.isPresent()){
            return ResponseEntity.ok().body(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Student> fetch() {
        return studentService.fetchAllStudents();
    }

}
