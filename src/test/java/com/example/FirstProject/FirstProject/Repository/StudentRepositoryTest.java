package com.example.FirstProject.FirstProject.Repository;


import com.example.FirstProject.FirstProject.Entity.Student;
import com.example.FirstProject.FirstProject.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
    public void setUp(){
        s1 = new Student("Waleed","w@hotmail.com","adasd","IT");
        studentRepository.save(s1);
        s2 = new Student("Ali","CS100","SDSDS","CS");
        studentRepository.save(s2);
        t1= new Teacher("Ali","ali@dlvmdl","adasd");
        teacherRepository.save(t1);

    }



}
