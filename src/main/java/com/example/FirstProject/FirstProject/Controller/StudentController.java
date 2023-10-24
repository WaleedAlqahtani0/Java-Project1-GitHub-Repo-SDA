package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Repository.StudentRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.StudentImp;
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
public class StudentController {

        /*
          -------- Autowired StudentImp,StudentRepository for accessing user data
         */

    @Autowired
    private StudentImp studentImp;

    @Autowired
    private StudentRepository studentRepository;


        /*-----------------------
          Welcome massage
        */
    @GetMapping("/welcome/students")
    public String HelloStudent(){
        return "Welcome Students";
    }


     /*--------------------
      - Get a list of all Student
      - return list of all Student
     */

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudent(){
        return studentImp.getAllStudent();
    }

     /*------------------
       - add a new Students
       - @RequestBody user the Students to be saved
       - @Valid to validation
       - I used try-catch to check there is not give anu error or Exception when added
         */

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


   /*----------------------
      - Delete Students with handling Exception
     */

    @DeleteMapping("/students/delete/{id}")
    public String deleteStudents(@PathVariable int id){
            Optional<Student> StudentsFound = studentRepository.findById(id);
            try {
                if (StudentsFound.isPresent()) {
                    studentImp.deleteStudent(id);
                    return "Student id deleted";
                } else {
                    return "Student with user id " + id + " not found";
                }
            } catch (Exception e) {
                return "Student not deleted";
            }
        }

     /*----------------------
      - Update students and I did the Exception in studentImp class
     */
    @PutMapping("/students/update/{id}")
    public String updateUsers(@PathVariable Integer id, @RequestBody Student student){
        return studentImp.UpdateStudent(id,student);

    }


}
