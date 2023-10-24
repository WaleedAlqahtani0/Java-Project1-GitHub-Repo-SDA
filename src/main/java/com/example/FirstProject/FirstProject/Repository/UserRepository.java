package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*

 * The UserRepository interface extends JpaRepository to allow operations on User entities in the database.

 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> { }
