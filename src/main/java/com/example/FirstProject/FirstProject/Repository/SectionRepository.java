package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

/*

  The SectionRepository interface extends JpaRepository to allow operations on User entities in the database.

 */
public interface SectionRepository extends JpaRepository<Section,Integer> {
}
