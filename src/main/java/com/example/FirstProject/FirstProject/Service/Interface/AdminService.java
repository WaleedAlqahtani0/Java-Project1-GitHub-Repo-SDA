package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Admin;
import java.util.List;
/*

  The AdminService is an interface that defines the methods that are available to perform operations on admin entities.

 */
public interface AdminService {

     /*

     List of methods to show all Admin, add , delete and update Admin.

    */

    public List<Admin> getAllAdmins();

    public Admin addAdmin(Admin admin);

    public void deleteAdmin(Integer id);

    public String UpdateAdmin(int id, Admin admin);
}
