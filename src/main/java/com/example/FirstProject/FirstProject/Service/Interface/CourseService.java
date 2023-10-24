package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Course;
import java.util.List;
/*

  The CourseService is an interface that defines the methods that are available to perform operations on course entities.

 */
public interface CourseService {
     /*

     List of methods to show all Courses, add , delete and update Courses.

    */

    public List<Course> getAllCourses();


    public Course addCourse(Course course);


    public void deleteCourse( String course);


    public String updateCourse(String courseId, Course course);
}
