package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/*

 * The  CourseRepository interface extends JpaRepository to allow operations on User entities in the database.

 */
public interface CourseRepository extends JpaRepository<Course,String> {
}
