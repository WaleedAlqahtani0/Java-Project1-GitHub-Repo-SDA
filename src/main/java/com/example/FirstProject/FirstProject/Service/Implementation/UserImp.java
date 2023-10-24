package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.UserRepository;
import com.example.FirstProject.FirstProject.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    /*
        UserImp implements UserService
     */
@Service
public class UserImp implements UserService {

    /*
      -------- Autowired UserRepository for database operations.
     */
    @Autowired
    private UserRepository userRepository;



    /*
     ------ get all the users by findAll()
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    /*
    --------- add a new user to the database
     */
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }


     /*
      ---------delete a users to the database
      */
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

     /*
       --------- Update a users to the database and check if the user not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */

    @Override
    public String UpdateUser(int id, User user) {
        Optional<User> UserFound = userRepository.findById(id);
        try {
            if (UserFound.isPresent()) {
                //2. Update the courseName
                user.setName(user.getName());
                //3. Save it in the Database
                userRepository.save(user);
                return "User Details Updated";
            } else {
                return "User with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Users Not Updated";
        }
    }
}

