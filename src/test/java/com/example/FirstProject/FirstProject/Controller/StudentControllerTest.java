package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Repository.StudentRepository;
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

 Testing with MocMcv / StudentControllerTest

 All The tests it's work I did try

 */
public class StudentControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private StudentRepository studentRepository;
    private MockMvc mockMvc;


    /*

     insert/add students

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Student student1 = new Student("name1","w@gmail.com","w000","CS");
        Student student2 = new Student("name2","n@gmail.com","n123","IT");
        studentRepository.saveAll(List.of(student1,student2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllStudentsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/students"))
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
    void deleteStudentsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/students/delete/1"))
                .andExpect(status().isNoContent());
    }

}
