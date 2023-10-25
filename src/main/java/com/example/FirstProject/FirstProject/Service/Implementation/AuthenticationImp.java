package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.UserRepository;
import com.example.FirstProject.FirstProject.Service.Interface.AuthenticationService;
import com.example.FirstProject.FirstProject.dtos.JwtAuthenticationRequest;
import com.example.FirstProject.FirstProject.dtos.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;



public class AuthenticationImp implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User signUp(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public JwtAuthenticationRequest signIn(SignUpRequest signUpRequest) {
        return null;
    }
}
