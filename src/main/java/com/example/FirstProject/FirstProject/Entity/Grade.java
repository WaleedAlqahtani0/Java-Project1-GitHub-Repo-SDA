package com.example.FirstProject.FirstProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Objects;
import java.util.Set;

    /*

       Grade entity extends User

     */
@Entity
public class Grade {

    // --------- Primary key (id) generated automatically by the database
    @Id
    private int id;


    // attributes
    private String studentName;

    private int score;


    /*---------------------
    @OneToOne relationship between One Grade to One student
  */
    @OneToOne (mappedBy = "grade")
    private Student student;

    /*---------------------
    @OneToOne relationship between Grade to One teacher
  */
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    //---------- constructors, getters, setters, equals, hashCode and toString;
    public Grade() { }

    public Grade(int id, String studentName, int score) {
        this.id = id;
        this.studentName = studentName;
        this.score = score;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return id == grade.id && score == grade.score && Objects.equals(studentName, grade.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, score);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                '}';
    }
}
