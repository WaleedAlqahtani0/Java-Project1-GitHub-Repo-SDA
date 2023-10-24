package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Grade;
import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Repository.GradeRepository;
import com.example.FirstProject.FirstProject.Service.Interface.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    /*
     GradeImp implements TeacherService
   */

@Service
public class GradeImp implements GradeService {

    /*
      -------- Autowired GradeRepository for database operations.
     */
    @Autowired
    private GradeRepository gradeRepository;

/*
     ------ get all the Grade by findAll()
     */

    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }

    /*
       ---------add a new Grade to the database
       */
    @Override
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    /*
       ---------delete a Grade to the database
       */
    @Override
    public void deleteGrade(Integer grade) {
   gradeRepository.deleteById(grade);
    }


    /*
       --------- Update a Grade to the database and check if the Grade not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */
    @Override
    public String UpdateGrade(int id, Grade grade) {
        Optional<Grade> gradeFound = gradeRepository.findById(id);
        if(gradeFound.isPresent()){
            //2. Update the Grade Id
            grade.setStudentName(grade.getStudentName());
            //3. Save it in the Database
            gradeRepository.save(grade);
            return "Grade Details Updated";
        }
         else
        {
            return "Grade with user id " + id + " not found";
        }
    }
}
