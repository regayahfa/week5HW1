package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.MODEL.Student;
import com.example.week5hw1.Responsty.StudentRepostry;
import com.example.week5hw1.Responsty.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentSirvis {
    private final  StudentRepostry studentRepostry;
    private  final TeacherRepostry teacherRepostry;


    public List<Student> getAllStudent() {
        return studentRepostry.findAll();

    }
    public void addStudent(Student student){
        studentRepostry.save(student);

    }
    public void updateStudent(Student student,Integer id) {
        Student student1 = studentRepostry.getReferenceById(id);
        if (student1 == null) {
            throw new ApiException("customer not found");
        }

        student1.setName(student.getName());
        studentRepostry.save(student1);
    }
    public void deleteStudent(Integer id){
       Student student=studentRepostry.getReferenceById(id);
        if(student==null){
            throw new ApiException("student not found");
        }

        studentRepostry.delete(student);
    }

    public Student getStudentById(Integer id ){
        Student student1=studentRepostry.findStudentById(id);
        if (student1==null) {
            throw new ApiException("sTUDENT not found");
        }
        return student1;
    }
    public void deleteCourseSet(Integer id, String major) {
        Student student1 = getStudentById(id);
        student1.setMajor(major);
        student1.getCourseSet().clear();
        if (student1 == null) {
            throw new ApiException("customer not found");
        }
    }
    }
