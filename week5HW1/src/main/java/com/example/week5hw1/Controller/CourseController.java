package com.example.week5hw1.Controller;

import com.example.week5hw1.ApiRespons.ApiRespons;
import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Servies.CourseServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor

public class CourseController {
    private final CourseServis courseServis;

    @GetMapping("/get")
    public ResponseEntity getAllCourse() {
        List<Course> courseList = courseServis.getAllCourse();
        return ResponseEntity.status(200).body(courseList);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseServis.addcourse(course);
        return ResponseEntity.status(200).body(new ApiRespons(" added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id) {
        courseServis.addcourse(course);
        return ResponseEntity.status(200).body("course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseServis.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted");

    }

    public ResponseEntity getCourseByid(@Valid @RequestBody Teacher teacher) {
        courseServis.getAllCourse();
return ResponseEntity.status(200).body("great");

    }

    }
