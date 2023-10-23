package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import java.util.List;


public interface TeacherService {

    public List<Teacher> getAllTeacher();

    public Teacher addTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public String UpdateTeacher(int id ,Teacher teacher);

}
