package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Course;
import java.util.List;

public interface CourseService {

    public List<Course> getAllCourses();


    public Course addCourse(Course course);


    public void deleteCourse( String course);


    public String updateCourse(String courseId, Course course);
}
