package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Repository.TeacherRepository;
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

 Testing with MocMcv /  TeacherControllerTest

 All The tests it's work I did try

 */
public class TeacherControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private TeacherRepository teacherRepository;
    private MockMvc mockMvc;


    /*

     insert/add teachers

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Teacher teacher1 = new Teacher("name1","w@gmail.com","w000");
        Teacher teacher2 = new Teacher("name2","n@gmail.com","n123");
        teacherRepository.saveAll(List.of(teacher1,teacher2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllTeacherTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/teachers"))
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
    void deleteTeacherTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/teachers/delete/1"))
                .andExpect(status().isNoContent());
    }

}


