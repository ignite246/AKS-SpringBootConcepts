package com.rahul.learning.SpringBootConcepts.services.impl;

import com.rahul.learning.SpringBootConcepts.dtos.AddStudentRequestDTO;
import com.rahul.learning.SpringBootConcepts.dtos.StudentDTO;
import com.rahul.learning.SpringBootConcepts.entities.Student;
import com.rahul.learning.SpringBootConcepts.repos.StudentRepository;
import com.rahul.learning.SpringBootConcepts.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudentsService() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(eachStudent -> modelMapper.map(eachStudent, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO getAStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student could not be find with id=" + studentId));

        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createStudent(AddStudentRequestDTO requestDTO) {
        Student newStudentEntity = modelMapper.map(requestDTO, Student.class);
        Student newSavedStudent = studentRepository.save(newStudentEntity);
        return modelMapper.map(newSavedStudent, StudentDTO.class);
    }
}
