package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Service.Implementation.TeacherImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherImp teacherImp;



    @GetMapping("/welcome/teacher")
    public String HelloTeacher(){
        return "Welcome Teacher";
    }

    /////////

    @GetMapping("/teachers")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeacher(){

        return teacherImp.getAllTeacher();
    }


    ///// post

    @PostMapping("/teachers/add")
    public ResponseEntity<String> addTeachers(@RequestBody @Valid Teacher teacher) {
        try {
            teacherImp.addTeacher(teacher);
            String massage = " Teacher add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Teacher not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }


    //// DELETE

    @DeleteMapping("/teachers/delete/{id}")
    public String deleteTeachers(@PathVariable int id){
        teacherImp.deleteTeacher(id);
        return "Teacher deleted";
    }

     ////// Update

    @PutMapping("/teachers/update/{id}")
    public String updateTeachers(@PathVariable Integer id, @RequestBody Teacher teacher){
        return teacherImp.UpdateTeacher(id,teacher);
    }




}
