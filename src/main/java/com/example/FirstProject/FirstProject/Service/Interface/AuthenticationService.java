package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.dtos.SignUpRequest;

public interface AuthenticationService {

    public User signUp(SignUpRequest signUpRequest);

    }
