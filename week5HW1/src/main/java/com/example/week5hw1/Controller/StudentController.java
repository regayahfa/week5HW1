package com.example.week5hw1.Controller;

import com.example.week5hw1.ApiRespons.ApiRespons;
import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.MODEL.Student;
import com.example.week5hw1.Servies.StudentSirvis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")

public class StudentController {
    private  final StudentSirvis studentSirvis;

    @GetMapping("/get")
    public ResponseEntity getAllStudent() {
        List<Student>studentList=studentSirvis.getAllStudent();
        return ResponseEntity.status(200).body(studentList);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentSirvis.addStudent(student);
        return ResponseEntity.status(200).body(new ApiRespons("student added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id) {
       studentSirvis.updateStudent(student,id);
        return ResponseEntity.status(200).body("students Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
       studentSirvis.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");

    }
    @GetMapping("/get/{id}")
    public ResponseEntity  StudentById(@PathVariable Integer id){
        Student student=studentSirvis.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
    @PutMapping("/updatemajor/{id}/{major}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @PathVariable String major) {
       studentSirvis.deleteCourseSet(id,major);
        return ResponseEntity.status(200).body("students Updated");
    }
}
