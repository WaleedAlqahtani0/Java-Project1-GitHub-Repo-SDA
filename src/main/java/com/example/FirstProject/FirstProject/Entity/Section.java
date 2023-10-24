package com.example.FirstProject.FirstProject.Entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;


/*

       Section entity extends User

     */
@Entity
@Table(name = "tbl_section")
public class Section {

    // --------- Primary key (id) generated automatically by the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;


    // attributes
     private String roomNumber;

     private String Instructor;

     /*---------------------
     @OneToMany relationship between One section to Many Student
   */

     @OneToMany(mappedBy = "section")
     private Set<Student> student;

    /*---------------------
    @ManyToOne relationship between Many section to One Course
  */
     @ManyToOne
     @JoinColumn( name = "course_id")
     private Course course;


    //---------- constructor and Getter,Setter and toString;

    public Section() {}

    public Section(String roomNumber, String instructor) {
        this.roomNumber = roomNumber;
        Instructor = instructor;
    }

    public int getId() {
        return id;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id &&  Objects.equals(roomNumber, section.roomNumber) && Objects.equals(Instructor, section.Instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, Instructor);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", Instructor='" + Instructor + '\'' +
                '}';
    }
}
