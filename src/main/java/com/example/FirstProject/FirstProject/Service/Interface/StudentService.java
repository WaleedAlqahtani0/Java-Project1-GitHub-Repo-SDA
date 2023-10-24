package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;

import java.util.List;

/*

  The StudentService is an interface that defines the methods that are available to perform operations on Student entities.

 */
public interface StudentService {

    /*

    List of methods to show all Student, add , delete and update Student.

   */
    public List<Student> getAllStudent();

    public Student addStudent(Student student);

    public void deleteStudent(int id);

    public String UpdateStudent(int id, Student student);
}
