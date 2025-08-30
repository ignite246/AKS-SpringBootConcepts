package com.rahul.learning.SpringBootConcepts.services;

import com.rahul.learning.SpringBootConcepts.dtos.AddStudentRequestDTO;
import com.rahul.learning.SpringBootConcepts.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudentsService();
    StudentDTO getAStudentById(Long studentId);
    StudentDTO createStudent(AddStudentRequestDTO requestDTO);
}
