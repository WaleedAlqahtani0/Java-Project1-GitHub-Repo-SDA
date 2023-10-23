package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.AdminRepository;
import com.example.FirstProject.FirstProject.Service.Interface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminImp implements AdminService {


    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Integer admin) {
        adminRepository.deleteById(admin);

    }

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

