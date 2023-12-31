package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*

 Testing with MocMcv / UserRepositoryTest

 All The tests it's work I did try

 */
@SpringBootTest
class UserControllerTest{

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private UserRepository userRepository;
    private MockMvc mockMvc;


    /*

     insert/add users

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        User user1 = new User("Waleed","w@gmail.com","w000");
        User user2 = new User("nawaf","n@gmail.com","n123");
        userRepository.saveAll(List.of(user1,user2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllUsersTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Waleed"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("nawaf"));
    }

/*

    MocMvc testing using: Delete

 */
    @Test
    void deleteUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/delete/1"))
                .andExpect(status().isNoContent());
    }

}
