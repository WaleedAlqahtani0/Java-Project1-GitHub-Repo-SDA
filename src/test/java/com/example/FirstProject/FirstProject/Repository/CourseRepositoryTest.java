package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Course course1;

    private Course course2;


    @Test
    public void setUp() {
        course1 = new Course("CS101", "Intro to Java");
        courseRepository.save(course1);
        course2 = new Course("CS102", "Databases");
        courseRepository.save(course2);
    }
}

