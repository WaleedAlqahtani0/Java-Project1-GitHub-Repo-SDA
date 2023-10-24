package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/*

  The AdminRepository  interface extends JpaRepository to allow operations on User entities in the database.

 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
