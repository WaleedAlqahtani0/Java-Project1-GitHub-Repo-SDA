package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.TeacherRepository;
import com.example.FirstProject.FirstProject.Service.Interface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    /*
       TeacherImp implements TeacherService
    */
@Service
public class TeacherImp implements TeacherService {

     /*
      -------- Autowired TeacherRepository for database operations.
     */

    @Autowired
    private TeacherRepository teacherRepository;

    /*
     ------ get all the Teacher by findAll()
     */

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

      /*
       ---------add a new Teacher to the database
       */
    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

      /*
       ---------delete a Teacher to the database
       */
    @Override
    public void deleteTeacher(int teacher) {
        teacherRepository.deleteById(teacher);
    }



     /*
       --------- Update a Teacher to the database and check if the Teacher not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */
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

