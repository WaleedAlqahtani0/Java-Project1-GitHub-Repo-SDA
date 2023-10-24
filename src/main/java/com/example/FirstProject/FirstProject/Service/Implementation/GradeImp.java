package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Grade;
import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Repository.GradeRepository;
import com.example.FirstProject.FirstProject.Service.Interface.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GradeImp implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;


    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Integer grade) {
   gradeRepository.deleteById(grade);
    }

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
