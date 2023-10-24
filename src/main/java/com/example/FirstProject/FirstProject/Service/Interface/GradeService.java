package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Grade;
import java.util.List;

/*

  The GradeService is an interface that defines the methods that are available to perform operations on grade entities.

 */
public interface GradeService {

     /*

     List of methods to show all Grade, add , delete and update Grade.

    */

    public List<Grade> getAllGrade();

    public Grade addGrade(Grade grade);

    public void deleteGrade(Integer id);

    public String UpdateGrade(int id, Grade grade);

}
