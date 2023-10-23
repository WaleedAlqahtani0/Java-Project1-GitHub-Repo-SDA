package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Service.Implementation.StudentImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentImp studentImp;

//////
    @GetMapping("/welcome/students")
    public String HelloStudent(){
        return "Welcome Students";
    }


    ///////// GET

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudent(){
        return studentImp.getAllStudent();
    }

    ////// POST

    @PostMapping("/students/add")
    public ResponseEntity<String> addStudents(@RequestBody @Valid Student student) {
        try {
            studentImp.addStudent(student);
            String massage = "student add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "student not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }


    ///////

    @DeleteMapping("/students/delete/{id}")
    public String deleteStudents(@PathVariable int id){
        studentImp.deleteStudent(id);
        return "Student deleted";
    }

    @PutMapping("/students/update/{id}")
    public String updateUsers(@PathVariable Integer id, @RequestBody Student student){

        return studentImp.UpdateStudent(id,student);

    }


}
