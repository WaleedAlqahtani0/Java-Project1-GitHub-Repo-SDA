package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.TeacherRepository;
import com.example.FirstProject.FirstProject.Service.Interface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherImp implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;



    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int teacher) {
        teacherRepository.deleteById(teacher);
    }

    @Override
    public String UpdateTeacher(int id, Teacher teacher) {
        Optional<Teacher> TeacherFound = teacherRepository.findById(id);
            if(TeacherFound.isPresent()){
                //2. Update the courseName
                teacher.setName(teacher.getName());
                //3. Save it in the Database
                teacherRepository.save(teacher);
                return "Teacher Details Updated";
            }
            else
            {
                return "Teacher with user id " + id + " not found";
            }
        }
    }

