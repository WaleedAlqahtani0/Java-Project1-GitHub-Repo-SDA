package com.example.FirstProject.FirstProject.Repository;


import com.example.FirstProject.FirstProject.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
