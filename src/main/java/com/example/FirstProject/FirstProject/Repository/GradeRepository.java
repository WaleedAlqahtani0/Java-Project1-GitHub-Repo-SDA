package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/*

  The GradeRepository interface extends JpaRepository to allow operations on User entities in the database.

 */
public interface GradeRepository extends JpaRepository<Grade,Integer> {
}
