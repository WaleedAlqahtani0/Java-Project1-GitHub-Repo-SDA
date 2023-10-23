package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.User;
import java.util.List;

public interface UserService {

   public List<User> getAllUsers();

    public User addUser(User user);

    public void deleteUser(Integer id);

    public String UpdateUser(int id, User user);
}
