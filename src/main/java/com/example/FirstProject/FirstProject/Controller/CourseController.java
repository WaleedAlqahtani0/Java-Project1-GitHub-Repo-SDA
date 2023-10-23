package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Service.Implementation.CourseImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseImp courseImp;

    @GetMapping("/welcome/courses")
    public String HelloCourses(){
        return "Welcome to Courses";
    }


    //////////
    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseImp.getAllCourses();
    }


    //////////////

    @PostMapping("/courses/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        try {
            courseImp.addCourse(course);
            String massage = "Course add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Course not found " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    //////////////

    @DeleteMapping("/courses/delete")
    public String deleteCourse(@RequestParam String courseId){
        courseImp.deleteCourse(courseId);
        return "course deleted";
    }

////////////////

    @PutMapping("/courses/update/{id}")
    public String updateCourse(@PathVariable String courseId, @RequestBody Course course){
        return courseImp.updateCourse(courseId,course);
    }


}
