package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.*;

import java.util.Set;


    /*

       Teacher entity extends User

     */

 @Entity
 @Table(name = "tbl_teacher")
 public class Teacher extends User {

     /*---------------------
      @OneToMany relationship between One Teacher to Many Student
      */
    @OneToMany(mappedBy = "teacher")
    private Set<Student> student;

     /*---------------------
      @OneToOne relationship between One Teacher to One Course
      */
    @OneToOne(mappedBy = "teacher")
    private Course course;

      /*---------------------
       @OneToOne relationship between One Teacher to One Grade
       */
    @OneToOne (mappedBy = "teacher")
    private Grade grade;


     //---------- constructor and constructor from SuperClass and toString;

    public Teacher() {}

    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return "Teacher{}";
    }

}
