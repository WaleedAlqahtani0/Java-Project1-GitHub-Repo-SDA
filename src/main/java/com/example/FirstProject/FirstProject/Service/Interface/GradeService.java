package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Grade;
import java.util.List;


public interface GradeService {

    public List<Grade> getAllGrade();

    public Grade addGrade(Grade grade);

    public void deleteGrade(Integer id);

    public String UpdateGrade(int id, Grade grade);

}
