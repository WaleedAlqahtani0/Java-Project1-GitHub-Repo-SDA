package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/*

  The TeacherRepository interface extends JpaRepository to allow operations on User entities in the database.

 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
