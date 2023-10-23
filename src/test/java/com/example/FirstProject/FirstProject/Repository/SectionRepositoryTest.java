package com.example.FirstProject.FirstProject.Repository;

import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SectionRepositoryTest {


        @Autowired
        private SectionRepository sectionRepository;

        private Section sec1;
        private Section sec2;

        @Test
        public void setUp(){
            sec1 = new Section("101A","Ali");
            sectionRepository.save(sec1);
            sec2 = new Section("202B","Omar");
            sectionRepository.save(sec2);

        }
}
