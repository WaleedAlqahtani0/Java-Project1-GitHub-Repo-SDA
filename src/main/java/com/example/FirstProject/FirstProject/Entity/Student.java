package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/*

       Teacher entity extends User

     */

@Entity
@Table(name = "tbl_student")
public class Student extends User {

    private String major;


 /*---------------------
     @ManyToOne relationship between Many Student to One Teacher
   */
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    /*---------------------
     @ManyToOne relationship between Many Student to One Course
   */

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    /*---------------------
     @OneToOne relationship between One Student to One Grade
   */
    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;


    /*---------------------
     @ManyToOne relationship between Many Student to One Section
   */
    @ManyToOne
    @JoinColumn( name = "section_id")
    private Section section;

    //---------- super constructor with private attribute and Getter,Setter and toString;

    public Student() {
    }

    public Student(String name, String email, String password, String major) {
        super(name, email, password);
        this.major = major;
    }

    public String getMajor() {

        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major);
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                '}';
    }
}
