package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Repository.CourseRepository;
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

 Testing with MocMcv / CourseControllerTest

 All The tests it's work I did try

 */
public class CourseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private CourseRepository courseRepository;
    private MockMvc mockMvc;


    /*

     insert/add courses

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Course course1 = new Course("CS200","JAVA");
        Course course2 = new Course("CS300","HTML");
        courseRepository.saveAll(List.of(course1,course2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllCourseTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("CS200"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("CS300"));
    }

    /*

        MocMvc testing using: Delete

     */
    @Test
    void deleteCourseTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/courses/delete/CS200"))
                .andExpect(status().isNoContent());
    }

}


