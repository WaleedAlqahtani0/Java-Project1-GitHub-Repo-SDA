package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.User;
import java.util.List;

/*

  The UserService is an interface that defines the methods that are available to perform operations on User entities.

 */

public interface UserService {

    /*

     List of methods to show all users, add , delete and update Users.

    */

   public List<User> getAllUsers();

    public User addUser(User user);

    public void deleteUser(Integer id);

    public String UpdateUser(int id, User user);
}
