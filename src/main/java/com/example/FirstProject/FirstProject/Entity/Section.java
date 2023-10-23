package com.example.FirstProject.FirstProject.Entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Section")
@Inheritance(strategy = InheritanceType.JOINED)
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     private String roomNumber;

     private String Instructor;

     @OneToMany(mappedBy = "section")
     private Set<Student> student;

     @ManyToOne
     @JoinColumn( name = "course_id")
     private Course course;

    public Section() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

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
