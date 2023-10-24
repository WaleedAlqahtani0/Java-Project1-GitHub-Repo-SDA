package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import java.util.List;

/*

  The TeacherService is an interface that defines the methods that are available to perform operations on Teacher entities.

 */
public interface TeacherService {

     /*

     List of methods to show all Teacher, add , delete and update Teacher.

    */

    public List<Teacher> getAllTeacher();

    public Teacher addTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public String UpdateTeacher(int id ,Teacher teacher);

}
