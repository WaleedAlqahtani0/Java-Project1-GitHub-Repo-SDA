package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*

 Testing with JUnit / AdminRepositoryTest

 All The tests it's work I did try

 */


@SpringBootTest
public class AdminRepositoryTest {

    /*
         -------- Autowired AdminRepository for accessing user data
       */
    @Autowired
    private AdminRepository adminRepository;

    /*
      add values
     */

    private Admin admin1;
    private Admin admin2;

    /*
        add new admin to database
     */
    @Test
    public void addAdminTest() {
        admin1 = new Admin("Ahamdo","joun@gmail.com","j123");
        adminRepository.save(admin1);
        admin2 = new Admin("naif","jack@gmail.com","j456");
        adminRepository.save(admin2);
    }


    @Test
    public void FindAllAdmin(){
        List<Admin> AdminList = adminRepository.findAll();
        assertEquals(2, AdminList.size());
    }

    /*

    Remove all

     */

    @Test
    public void removeAll(){
        adminRepository.deleteAll();
    }

}
