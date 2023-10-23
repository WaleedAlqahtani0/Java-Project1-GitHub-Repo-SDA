package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Admin;
import com.example.FirstProject.FirstProject.Entity.User;

import java.util.List;

public interface AdminService {

    public List<Admin> getAllAdmins();

    public Admin addAdmin(Admin admin);

    public void deleteAdmin(Integer id);

    public String UpdateAdmin(int id, Admin admin);
}
