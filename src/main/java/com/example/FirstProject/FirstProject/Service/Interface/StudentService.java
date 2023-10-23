package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudent();

    public Student addStudent(Student student);

    public void deleteStudent(Integer id);

    public String UpdateStudent(int id, Student student);
}
