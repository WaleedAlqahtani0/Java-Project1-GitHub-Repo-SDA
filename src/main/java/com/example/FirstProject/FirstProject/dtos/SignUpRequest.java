package com.example.FirstProject.FirstProject.dtos;

import lombok.Data;
import java.time.LocalDate;


@Data
public class SignUpRequest {
    private String username;
    private String password;
    private LocalDate date;
}
