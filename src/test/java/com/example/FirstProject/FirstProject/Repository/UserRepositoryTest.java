package com.example.FirstProject.FirstProject.Repository;

/*

 Testing with JUnit / UserRepositoryTest

 All The tests it's work I did try

 */
import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User user1;
   private User user2;

    @Test
    public void setUp(){
        user1 = new User("waleed","W@gmail.com","w123");
         userRepository.save(user1);
        user2 = new User("Ali","A@gmail","456");
        userRepository.save(user2);
    }

    /*

     find all
     */

    @Test
    public void FindAllUser(){
        List<User> UserList = userRepository.findAll();
        assertEquals(2, UserList.size());
    }

    /*

   remove

    */

    @Test
    public void removeAll(){
        userRepository.deleteAll();
    }

}
