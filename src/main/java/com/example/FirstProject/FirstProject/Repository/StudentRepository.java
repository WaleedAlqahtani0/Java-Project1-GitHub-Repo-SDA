package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/*

 * The StudentRepository interface extends JpaRepository to allow operations on User entities in the database.

 */

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
