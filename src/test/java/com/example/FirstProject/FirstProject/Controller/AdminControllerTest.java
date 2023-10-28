package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Repository.AdminRepository;
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

 Testing with MocMcv / AdminControllerTest

 All The tests it's work I did try

 */
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private AdminRepository adminRepository;
    private MockMvc mockMvc;


    /*

     insert/add admin

     */
    @Test
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Admin admin1 = new Admin("name5","w@gmail.com","w000");
        Admin admin2 = new Admin("name6","n@gmail.com","n123");
        adminRepository.saveAll(List.of(admin1,admin2));
    }

    /*

        MocMvc testing using: Get

     */

    @Test
    void getAllAdminTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admins"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name5"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("name6"));
    }

    /*

        MocMvc testing using: Delete

     */
    @Test
    void deleteAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admins/delete/5"))
                .andExpect(status().isNoContent());
    }

}

