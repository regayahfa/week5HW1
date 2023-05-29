package com.example.week5hw1.Responsty;

import com.example.week5hw1.MODEL.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepostry extends JpaRepository<Teacher,Integer> {
Teacher getAllById(Integer id);

Teacher getDetelisById(Teacher teacher);
}
