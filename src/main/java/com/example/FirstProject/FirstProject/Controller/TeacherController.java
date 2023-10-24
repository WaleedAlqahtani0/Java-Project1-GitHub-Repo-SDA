package com.example.FirstProject.FirstProject.Controller;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Repository.TeacherRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.TeacherImp;
import jakarta.validation.Valid;
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
public class TeacherController {

        /*
          -------- Autowired TeacherImp for accessing user data
         */
    @Autowired
    private TeacherImp teacherImp;

    @Autowired
    private TeacherRepository teacherRepository;


        /*-----------------------
           Welcome massage
         */
    @GetMapping("/welcome/teacher")
    public String HelloTeacher(){
        return "Welcome Teacher";
    }


    /*--------------------
      - Get a list of all Teacher
      - return list of all Teacher
     */

    @GetMapping("/teachers")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeacher(){

        return teacherImp.getAllTeacher();
    }


    /*------------------
       - add a new teacher
       - use @RequestBody the teacher to be saved
       - @Valid to validation
       - I used try-catch to check there is not give anu error or Exception when added
         */

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

    /*----------------------
      - Delete teacher with handling Exception
     */

    @DeleteMapping("/teachers/delete/{id}")
    public String deleteTeachers(@PathVariable int id){
        {
            Optional<Teacher> TeacherFound = teacherRepository.findById(id);
            try {
                if (TeacherFound.isPresent()) {
                    teacherImp.deleteTeacher(id);
                    return "Teacher id deleted";
                } else {
                    return "Teacher with user id " + id + " not found";
                }
            } catch (Exception e) {
                return "Teacher  not deleted";
            }
        }
    }

     /*----------------------
      - Update teacher and I did the Exception in TeacherImp class
     */

    @PutMapping("/teachers/update/{id}")
    public String updateTeachers(@PathVariable Integer id, @RequestBody Teacher teacher){
        return teacherImp.UpdateTeacher(id,teacher);
    }

}
