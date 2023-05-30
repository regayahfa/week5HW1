package com.example.week5hw1.Controller;

import com.example.week5hw1.DTO.TeacherDTO;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Servies.TeacherServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherServis teacherServis;

    @GetMapping("/get")
    public ResponseEntity getAllById(){
        List<Teacher>teacherList=teacherServis.getAllTeacher();
        return ResponseEntity.status(200).body(teacherList);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody TeacherDTO teacherDTO){
        teacherServis.addTeacher(teacherDTO);
        return ResponseEntity.status(200).body("teacher added");
    }
    @PutMapping("/update")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer ID){
    List<Teacher> teacherList=teacherServis.getAllTeacher();
        return ResponseEntity.status(200).body("teacher updated");
    }
    @PostMapping("/delete")
    public ResponseEntity deleteteacher(@PathVariable Integer id){
        teacherServis.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");
    }
    public ResponseEntity getDitelsById(Teacher teacher){
        List<Teacher>teacherList=teacherServis.getAllTeacher();
        return ResponseEntity.status(200).body("good");
    }

}
