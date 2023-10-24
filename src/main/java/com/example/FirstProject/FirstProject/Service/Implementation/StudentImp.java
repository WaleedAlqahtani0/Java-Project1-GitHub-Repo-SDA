package com.example.FirstProject.FirstProject.Service.Implementation;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.StudentRepository;
import com.example.FirstProject.FirstProject.Service.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
       StudentImp implements StudentService
    */
@Service
public class StudentImp implements StudentService {


    /*
      -------- Autowired studentRepository for database operations.
     */

    @Autowired
    private StudentRepository studentRepository;


    /*
        ------ get all the Student by findAll()
        */
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    /*
       ---------add a new Student to the database
       */
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /*
       ---------delete a Student to the database
       */
    @Override
    public void deleteStudent(Integer student) {
        studentRepository.deleteById(student);
    }

    /*
       --------- Update a Student to the database and check if the Student not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */
    @Override
    public String UpdateStudent(int id, Student student) {
        Optional<Student> StudentFound = studentRepository.findById(id);
        if(StudentFound.isPresent()){
            //2. Update the courseName
            student.setName(student.getName());
            //3. Save it in the Database
            studentRepository.save(student);
            return "Student Details Updated";
        }
        else
        {
            return "Student with user id " + id + " not found";
        }
      }
    }

