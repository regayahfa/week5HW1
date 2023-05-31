package com.example.week5hw1.Servies;

import com.example.week5hw1.ApiException.ApiException;
import com.example.week5hw1.MODEL.Course;
import com.example.week5hw1.Responsty.CourseRepostry;
import com.example.week5hw1.Responsty.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor
public class CourseServis {
    private final CourseRepostry courseRepostry;
    private final TeacherRepostry teacherRepostry;

    public List<Course> getAllCourse() {
        return courseRepostry.findAll();

    }
    public void addcourse(Course course){
       courseRepostry.save(course);

    }
    public void updateCourse(Course course,Integer id) {
        Course course1 = courseRepostry.getCourseById(id);
        if (course1 == null) {
            throw new ApiException("customer not found");
        }

        course1.setName(course.getName());
        courseRepostry.save(course1);
    }

    public void deleteCourse(Integer id){
       Course course=courseRepostry.getCourseById(id);
        if(course==null){
            throw new ApiException("customer not found");
        }

        courseRepostry.delete(course);
    }
public String getById(Integer id) {
    Course course=courseRepostry.getCourseById(id);
   if (course==null){
       throw new ApiException("not found");
   }
   return course.getTeacher().getName();
}
    }