package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.UserRepository;
import com.example.FirstProject.FirstProject.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer user) {
           userRepository.deleteById(user);

    }

    @Override
    public String UpdateUser(int id, User user) {
        Optional<User> UserFound = userRepository.findById(id);
        if(UserFound.isPresent()){
            //2. Update the courseName
            user.setName(user.getName());
            //3. Save it in the Database
            userRepository.save(user);
            return "User Details Updated";
        }
        else
        {
            return "User with user id " + id + " not found";
        }
    }
    }

