package com.rahul.learning.SpringBootConcepts.repos;

import com.rahul.learning.SpringBootConcepts.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
