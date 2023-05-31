package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.DTO.TeacherDTO;
import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Responsty.AddressRepostry;
import com.example.week5hw1.Responsty.CourseRepostry;
import com.example.week5hw1.Responsty.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServis {
    private final TeacherRepostry teacherRepostry;
    private final CourseRepostry courseRepostry;
//    private final AddressRepostry addressRepostry;
    public List<Teacher> getAllTeacher(){
        return teacherRepostry.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepostry.save(teacher);
    }

    public void updateteacher(Integer id, Teacher teacher){
        Teacher t=teacherRepostry.findTeacherById(id);
        if (t==null){
            throw new ApiException("the teacher not found");
        }
        t.setName(teacher.getName());
        t.setSalary(teacher.getSalary());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());

        teacherRepostry.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepostry.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("not found");
        }
        teacherRepostry.delete(teacher);
    }
        public Teacher getDetelisById(Integer id){
            Course c = courseRepostry.getCourseById(id);
        if (c ==null){
            throw new ApiException("not found");
        }
        return c.getTeacher();
}
}
