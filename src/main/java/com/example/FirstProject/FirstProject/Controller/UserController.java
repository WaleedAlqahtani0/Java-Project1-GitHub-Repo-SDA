package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Service.Implementation.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserImp userImp;

///
    @GetMapping("/welcome/users")
    public String HelloUser(){
        return "Welcome Users";
    }

    ////// get using test

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userImp.getAllUsers();
    }

    ///// post

    @PostMapping("/users/add")
    public ResponseEntity<String> addUsers(@RequestBody User user) {
        try {
            userImp.addUser(user);
            String massage = "User add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "User not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    //// DELETE

    @DeleteMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable int id){
        userImp.deleteUser(id);
        return "User deleted";
    }

    //// Update

    @PutMapping("/users/update/{id}")
    public String updateUsers(@PathVariable Integer id, @RequestBody User user){
        return userImp.UpdateUser(id,user);
    }

}
