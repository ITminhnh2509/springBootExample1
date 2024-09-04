package com.example.buoi2mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    StudentRepository repository;

    @RequestMapping("")
    public ResponseEntity<List<Student>> getAll(@RequestParam(required = false) String title){
        try {
            List<Student> students = new ArrayList<>();
            repository.findAll().forEach(students::add);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            // Add logging to understand what went wrong
            e.printStackTrace(); // or use a logger to log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try {
            Student student1 = repository.save(new Student(
                    student.get_id(),
                    student.getUser_id(),
                    student.getEmail(),
                    student.getName(),
                    student.getFamily_name(),
                    student.getCreated_at(),
                    student.getUpdated_at(),
                    student.getLast_login(),
                    false));
            return new ResponseEntity<>(student1,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


