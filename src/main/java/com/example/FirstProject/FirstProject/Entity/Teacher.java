package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.*;

import java.util.Set;

 @Entity
 @Table(name = "Teacher")
 public class Teacher extends User {

    @OneToMany(mappedBy = "teacher")
    private Set<Student> student;

    @OneToOne(mappedBy = "teacher")
    private Course course;

    @OneToOne (mappedBy = "teacher")
    private Grade grade;

    public Teacher() {
    }

    public Teacher(String name, String email, String password) {

        super(name, email, password);
    }


    @Override
    public String toString() {
        return "Teacher{}";
    }

}
