package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
