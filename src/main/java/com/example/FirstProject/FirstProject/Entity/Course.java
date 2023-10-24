package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;
import java.util.Set;


    /*

       Course entity extends User

     */
    @Entity
    @Table(name = "Course")
    public class Course {

        // --------- Primary key (courseId) generated automatically by the database
    @Id
    private String courseId;


     //------ attribute
     @NotEmpty(message = " Not Found ")
     private String courseName;

        /*---------------------
          @OneToMany relationship between One course to Many Student
          */
    @OneToMany(mappedBy = "course")
    private Set<Student> student;

        /*---------------------
          @OneToMany relationship between One course to One teacher
          */
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

        /*---------------------
          @OneToMany relationship between One course to Many section
          */
    @OneToMany(mappedBy = "course")
    private Set<Section> section;

        //---------- constructor and Getter,Setter,equals,hashCode and toString
    public Course() {
    }

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(courseName, course.courseName) && Objects.equals(teacher, course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, teacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}