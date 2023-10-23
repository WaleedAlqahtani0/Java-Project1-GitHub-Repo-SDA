package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Repository.CourseRepository;
import com.example.FirstProject.FirstProject.Service.Interface.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImp implements CourseService {


    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String course) {
        courseRepository.deleteById(course);

    }

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

