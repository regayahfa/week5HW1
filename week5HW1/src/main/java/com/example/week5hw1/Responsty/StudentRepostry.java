package com.example.week5hw1.Responsty;

import com.example.week5hw1.MODEL.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepostry extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
