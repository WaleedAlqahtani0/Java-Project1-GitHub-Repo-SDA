package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Repository.SectionRepository;
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

 Testing with MocMcv / SectionControllerTest

 All The tests it's work I did try

 */

public class SectionControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SectionRepository sectionRepository;
    private MockMvc mockMvc;


    /*

     insert/add sections

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Section section1 = new Section("CS200","name3");
        Section section2 = new Section("CS300","name4");
        sectionRepository.saveAll(List.of(section1,section2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllSectionTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/sections"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name3"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name4"));
    }

    /*

        MocMvc testing using: Delete

     */
    @Test
    void deleteSectionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/sections/delete/3"))
                .andExpect(status().isNoContent());
    }
}
