package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Course;
import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.Teacher;
import com.example.FirstProject.FirstProject.Entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 Testing with JUnit / SectionRepositoryTest

 All The tests it's work I did try

 */

@SpringBootTest
public class SectionRepositoryTest {


        @Autowired
        private SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

        private Section sec1;
        private Section sec2;
        private Course course;
        private Teacher teacher;

        /*

          add/insert
         */

        @Test
        public void addSection(){
            sec1 = new Section("101A","Raneem");
            sectionRepository.save(sec1);
            teacher = new Teacher("Bader","a@gmail.com","a123");
            teacherRepository.save(teacher);
            course= new Course("CS101", "Intro to java");
            courseRepository.save(course);
        }

    /*

 find all
 */
    @Test
    public void FindAllSection(){
        List<Section> SectionList = sectionRepository.findAll();
        List<Course> CourseList = courseRepository.findAll();
        List<Teacher> TeacherList = teacherRepository.findAll();
        assertEquals(1, SectionList.size());
        assertEquals(1, CourseList.size());
        assertEquals(1, TeacherList.size());


    }

    /*

remove

*/
    @Test
    public void removeAll(){
        sectionRepository.deleteAll();
    }


}
