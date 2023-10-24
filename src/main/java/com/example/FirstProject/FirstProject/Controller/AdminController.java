package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Repository.AdminRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.AdminImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    /*
     * REST API for User
     */
@RestController
public class AdminController {

      /*
         -------- Autowired  AdminImp, AdminRepository for accessing user data
       */

    @Autowired
    private AdminImp adminImp;

    @Autowired
    private AdminRepository adminRepository;


    /*--------------------
           - Get a list of all Admin
           - return list of all Admin
          */

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmin(){
        return adminImp.getAllAdmins();
    }

    /*------------------
          - add a new  Admin
          - @RequestBody  Admin to be saved
          - @Valid to validation
          - I used try-catch to check there is not give anu error or Exception when added
            */

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

    /*----------------------
         - Delete  Admin with handling Exception
        */

    @DeleteMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable int id){
        Optional<Admin> AdminFound = adminRepository.findById(id);
        try {
            if (AdminFound.isPresent()) {
                adminImp.deleteAdmin(id);
                return "Admin id deleted";
            } else {
                return "Admin with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Admin not deleted";
        }
    }


     /*----------------------
      - Update Admin and I did the Exception in sectionImp class
     */

        @PutMapping("/admins/update/{id}")
    public String updateAdmin(@PathVariable Integer id, @RequestBody Admin admin){
        return adminImp.UpdateAdmin(id,admin);
    }

}
