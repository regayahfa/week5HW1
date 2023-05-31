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
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherServis.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added");
    }
    @PutMapping("/update/{ID}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer ID){
    teacherServis.updateteacher(ID,teacher);
        return ResponseEntity.status(200).body("teacher updated");
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity deleteteacher(@PathVariable Integer id){
        teacherServis.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getDitelsById(@PathVariable Integer id){
        //List<Teacher>teacherList=teacherServis.getAllTeacher();
        return ResponseEntity.status(200).body(teacherServis.getDetelisById(id));
    }

}
