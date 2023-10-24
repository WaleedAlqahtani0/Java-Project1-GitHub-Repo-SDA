package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Repository.CourseRepository;
import com.example.FirstProject.FirstProject.Service.Interface.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
       CourseImp implements TeacherService
    */
@Service
public class CourseImp implements CourseService {

    /*
          -------- Autowired CourseRepository  for database operations.
         */
    @Autowired
    private CourseRepository courseRepository;

    /*
         ------ get all the Course by findAll()
         */
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /*
       ---------add a new Course to the database
       */
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    /*
       ---------delete a Course to the database
       */
    @Override
    public void deleteCourse(String course) {
        courseRepository.deleteById(course);

    }

    /*
       --------- Update a Course to the database and check if the Course not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */
    @Override
    public String updateCourse(String courseId, Course course) {
        Optional<Course> courseFound = courseRepository.findById(courseId);
        if (courseFound.isPresent()) {
            course.setCourseName(course.getCourseName());
            courseRepository.save(course);
            return " Course Update";
        } else {
            return " course code " + courseId + " Not found";
        }
    }
}

