package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 Testing with JUnit / TeacherRepositoryTest

 All The tests it's work I did try

 */
@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    private Teacher t1;


    @Test
    public void add(){
        t1= new Teacher("Hector","ali@dlvmdl","adasd");
        teacherRepository.save(t1);
    }

    /*

     find all
     */
    @Test
    public void FindAllTeacher(){
        List<Teacher> TeacherList = teacherRepository.findAll();
        assertEquals(1, TeacherList.size());
    }
    /*

   remove

    */
    @Test
    public void removeAll(){
        teacherRepository.deleteAll();
    }

}
