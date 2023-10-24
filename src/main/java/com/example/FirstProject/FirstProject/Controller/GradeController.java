package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Grade;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Service.Implementation.GradeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeImp gradeImp;


    ////////// GET

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getAllGrade(){
        return gradeImp.getAllGrade();
    }

    /////////// Post

    @PostMapping("/grades/add")
    public ResponseEntity<String> addGrade(@RequestBody Grade grade) {
        try {
            gradeImp.addGrade(grade);
            String massage = "Grade add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Grade not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    ///////////// DELETE

    @DeleteMapping("/grades/delete/{id}")
    public String deleteGrade(@PathVariable int id){
        gradeImp.deleteGrade(id);
        return "Grade deleted";
    }

    ///////// UPDATE


    @PutMapping("/grades/update/{id}")
    public String updateGrade(@PathVariable Integer id, @RequestBody Grade grade){
        return gradeImp.UpdateGrade(id,grade);
    }

}
