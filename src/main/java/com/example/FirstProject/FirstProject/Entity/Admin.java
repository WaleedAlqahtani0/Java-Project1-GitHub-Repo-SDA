package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*

       Admin entity extends User

     */
@Entity
@Table(name = "Admin")
public class Admin extends User{

    //---------- constructor and constructor from SuperClass and toString;
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
