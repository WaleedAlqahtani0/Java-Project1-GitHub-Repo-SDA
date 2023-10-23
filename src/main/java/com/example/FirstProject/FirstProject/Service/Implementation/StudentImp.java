package com.example.FirstProject.FirstProject.Service.Implementation;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.StudentRepository;
import com.example.FirstProject.FirstProject.Service.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImp implements StudentService {


    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer student) {
        studentRepository.deleteById(student);
    }

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

