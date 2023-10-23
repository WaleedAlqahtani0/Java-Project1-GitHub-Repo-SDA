package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Service.Implementation.AdminImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminImp adminImp;

    @GetMapping("/welcome/admin")
    public String HelloAdmin(){
        return "Welcome to the School";
    }

//////////////

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmin(){
        return adminImp.getAllAdmins();
    }

    ///////////////

    @PostMapping("/admins/add")
    public ResponseEntity<String> addAdmin(@RequestBody @Valid Admin admin) {
        try {
            adminImp.addAdmin(admin);
            String massage = "Admin add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Admin not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    //// DELETE

    @DeleteMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable int id){
        adminImp.deleteAdmin(id);
        return "Admin deleted";
    }

    //// Update

    @PutMapping("/admins/update/{id}")
    public String updateAdmin(@PathVariable Integer id, @RequestBody Admin admin){
        return adminImp.UpdateAdmin(id,admin);
    }



}
