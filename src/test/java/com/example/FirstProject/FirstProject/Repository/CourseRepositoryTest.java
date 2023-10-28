package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 Testing with JUnit / CourseRepositoryTest

 All The tests it's work I did try

 */


@SpringBootTest
public class CourseRepositoryTest {

    /*
        -------- Autowired CourseRepository for accessing user data
      */
    @Autowired
    private CourseRepository courseRepository;

    private List<Course> course;


    /*
        add new Courses to database
     */
    @Test
    public void setUp() {

        course = courseRepository.saveAll(
                List.of(
                        new Course("CS101", "Intro to java"),
                        new Course("CS103", "Databases")
                )
        );
    }


    /*

    remove

     */
    @Test
    public void removeAll(){
        courseRepository.deleteAll();
    }

    /*

     find all
     */
    @Test
    public void FindAllCourses(){
        List<Course> courseList = courseRepository.findAll();
        assertEquals(2, courseList.size());
    }
}

