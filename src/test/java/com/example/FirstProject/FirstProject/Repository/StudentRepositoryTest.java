package com.example.FirstProject.FirstProject.Repository;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 Testing with JUnit / StudentRepositoryTest

 All The tests it's work I did try

 */
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    private Student s1;

    private Student s2;

    private Teacher t1;

    @Test
    public void addTest(){
        s1 = new Student("Jdcd","w@hotmail.com","adasd","IT");
        studentRepository.save(s1);
        s2 = new Student("momcd","CS100","SDSDS","CS");
        studentRepository.save(s2);
        t1= new Teacher("cdcdc","ali@dlvmdl","adasd");
        teacherRepository.save(t1);
    }
    /*

     find all
     */
    @Test
    public void FindAll(){
        List<Teacher> TeacherList = teacherRepository.findAll();
        List<Student> StudentList = studentRepository.findAll();
        assertEquals(1, TeacherList.size());
        assertEquals(2, StudentList.size());
    }
    /*

   remove

    */
    @Test
    public void removeAll(){
        teacherRepository.deleteAll();
        studentRepository.deleteAll();
    }


}
