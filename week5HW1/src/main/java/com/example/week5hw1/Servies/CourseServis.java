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
        Course course1 = courseRepostry.getReferenceById(id);
        if (course1 == null) {
            throw new ApiException("customer not found");
        }

        course1.setName(course.getName());
        courseRepostry.save(course1);
    }

    public void deleteCourse(Integer id){
       Course course=courseRepostry.getReferenceById(id);
        if(course==null){
            throw new ApiException("customer not found");
        }

        courseRepostry.delete(course);
    }
public void getById(Integer id, String teacher) {
    Course course=courseRepostry.findCourseByid(teacher,id);
   if (course==null){
       throw new ApiException("not found");
   }
   courseRepostry.findCourseByid(teacher,id);
}
    }