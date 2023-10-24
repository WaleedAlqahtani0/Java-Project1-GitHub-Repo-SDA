package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Grade;
import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.GradeRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.GradeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    /*
     * REST API for User
     */
@RestController
public class GradeController {

        /*
      -------- Autowired GradeImp,GradeRepository for accessing user data
           */
    @Autowired
    private GradeImp gradeImp;

    private GradeRepository gradeRepository;


     /*--------------------
       - Get a list of all grade
       - return list of all grade
      */

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getAllGrade(){
        return gradeImp.getAllGrade();
    }

     /*------------------
          - add a new grade
          - @RequestBody the grade to be saved
          - @Valid to validation
          - I used try-catch to check there is not give anu error or Exception when added
            */

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

   /*----------------------
         - Delete grade with handling Exception
        */

    @DeleteMapping("/grades/delete/{id}")
    public String deleteGrade(@PathVariable int id){
        Optional<Grade> GradeFound = gradeRepository.findById(id);
        try {
            if (GradeFound.isPresent()) {
                gradeImp.deleteGrade(id);
                return "Grade id deleted";
            } else {
                return "Grade with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Grade not deleted";
        }
    }


     /*----------------------
      - Update grade and I did the Exception in gradeImp class
     */


    @PutMapping("/grades/update/{id}")
    public String updateGrade(@PathVariable Integer id, @RequestBody Grade grade){
        return gradeImp.UpdateGrade(id,grade);
    }

}
