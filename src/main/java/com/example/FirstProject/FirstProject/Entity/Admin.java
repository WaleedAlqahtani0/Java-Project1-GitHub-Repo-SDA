package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User{

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {

        return "Admin{}";
    }

}
