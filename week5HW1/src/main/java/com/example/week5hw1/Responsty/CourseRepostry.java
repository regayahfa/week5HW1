package com.example.week5hw1.Responsty;

import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.MODEL.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepostry extends JpaRepository<Course, Integer> {
Course getCourseById(Integer id);

}
