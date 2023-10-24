package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.AdminRepository;
import com.example.FirstProject.FirstProject.Service.Interface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
       AdminImp implements TeacherService
    */
@Service
public class AdminImp implements AdminService {

    /*
          -------- Autowired AdminRepository for database operations.
         */
    @Autowired
    private AdminRepository adminRepository;

    /*
     ------ get all the Admin by findAll()
     */
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    /*
       ---------add a new Admin to the database
       */
    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    /*
       ---------delete a Admin to the database
       */
    @Override
    public void deleteAdmin(Integer admin) {
        adminRepository.deleteById(admin);

    }

    /*
       --------- Update a Admin to the database and check if the Admin not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */
    @Override
    public String UpdateAdmin(int id, Admin admin) {
        Optional<Admin> AdminFound = adminRepository.findById(id);
        if(AdminFound.isPresent()){
            //2. Update the courseName
            admin.setName(admin.getName());
            //3. Save it in the Database
            adminRepository.save(admin);
            return "Admin Details Updated";
        }
        else
        {
            return "Admin with user id " + id + " not found";
        }
      }
    }

