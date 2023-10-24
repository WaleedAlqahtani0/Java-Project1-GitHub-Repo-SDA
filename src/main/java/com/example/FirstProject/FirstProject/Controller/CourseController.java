package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Repository.CourseRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.CourseImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    /*
     * REST API for User
     */
@RestController
public class CourseController {

    /*
         -------- Autowired CourseImp,CourseRepository for accessing user data
       */
    @Autowired
    private CourseImp courseImp;

    @Autowired
    private CourseRepository courseRepository;


        /*--------------------
           - Get a list of all Courses
           - return list of all Courses
          */

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAllCourses() {
        return courseImp.getAllCourses();
    }


        /*------------------
             - add a new Course
             - @RequestBody  the Course to be saved
             - @Valid to validation
             - I used try-catch to check there is not give an error or Exception when added
               */
    @PostMapping("/courses/add")
    public ResponseEntity<String> addCourse(@RequestBody @Valid Course course) {
        try {
            courseImp.addCourse(course);
            String massage = "Course add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Course not found " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

   /*----------------------
         - Delete Course with handling Exception
        */

    @DeleteMapping("/courses/delete")
    public String deleteCourse(@RequestParam String courseId){
            Optional<Course> CourseFound = courseRepository.findById(courseId);
            try {
                if (CourseFound .isPresent()) {
                    courseImp.deleteCourse(courseId);
                    return "Course id deleted";
                } else {
                    return "Course with user id " + courseId + " not found";
                }
            } catch (Exception e) {
                return "Course not deleted";
            }
        }


 /*----------------------
      - Update Course and I did the Exception in CourseImp class
     */


    @PutMapping("/courses/update")
    public String updateCourse(@RequestParam String courseId, @RequestBody Course course){
        return courseImp.updateCourse(courseId,course);
    }


}
