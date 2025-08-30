package com.rahul.learning.SpringBootConcepts.controllers;

import com.rahul.learning.SpringBootConcepts.dtos.AddStudentRequestDTO;
import com.rahul.learning.SpringBootConcepts.dtos.StudentDTO;
import com.rahul.learning.SpringBootConcepts.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudentsService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long studentId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAStudentById(studentId));
    }

    @PostMapping("/")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody @Valid AddStudentRequestDTO requestDTO){
       StudentDTO savedStudent = studentService.createStudent(requestDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
}
