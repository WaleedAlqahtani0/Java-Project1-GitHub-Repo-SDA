package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Grade;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.GradeRepository;
import com.example.FirstProject.FirstProject.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*

 Testing with MocMcv / GradeControllerTest

 All The tests it's work I did try

 */
public class GradeControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private GradeRepository gradeRepository;
    private MockMvc mockMvc;


    /*

     insert/add grade

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Grade grade1 = new Grade(1,"name1",99);
        Grade grade2 = new Grade(2,"name2",88);
        gradeRepository.saveAll(List.of(grade1,grade2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllGradeTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/grades"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name2"));
    }

    /*

        MocMvc testing using: Delete

     */
    @Test
    void deleteGradeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/grades/delete/1"))
                .andExpect(status().isNoContent());
    }

}


