package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.DTO.TeacherDTO;
import com.example.week5hw1.MODEL.Teacher;
import com.example.week5hw1.Responsty.AddressRepostry;
import com.example.week5hw1.Responsty.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServis {
    private final TeacherRepostry teacherRepostry;
    private final AddressRepostry addressRepostry;
    public List<Teacher> getAllTeacher(){
        return teacherRepostry.findAll();
    }

    public void addTeacher(TeacherDTO dto){
        Teacher teacher=teacherRepostry.getDetelisById(dto.getName());
        if (teacher==null){
            throw new ApiException("can not add teacher");
        }
        Teacher teacher1=new Teacher();
        teacherRepostry.save(teacher);
    }

    public void updateteacher(TeacherDTO teacherDTO){
        Teacher teacher=teacherRepostry.findAll().get(teacherDTO.getId());
        if (teacher==null){
            throw new ApiException("the teacher not update");
        }
        teacher.setAddress(teacher.getAddress());
        teacher.setSalary(teacher.getSalary());

        teacherRepostry.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepostry.getAllById(id);
        if (teacher==null){
            throw new ApiException("not found");
        }
        teacherRepostry.delete(teacher);
    }
public void getDetelisById(Integer id){
        Teacher teacher=teacherRepostry.findAll().get(id);
        if (teacher==null){
            throw new ApiException("not found");
        }
        teacherRepostry.getAllById(id);
}
}
