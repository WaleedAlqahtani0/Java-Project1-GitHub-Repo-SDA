package com.example.FirstProject.FirstProject.Service.Implementation;

import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.SectionRepository;
import com.example.FirstProject.FirstProject.Service.Interface.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionImp implements SectionService {


    @Autowired
    private SectionRepository sectionRepository;


    @Override
    public List<Section> getAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public Section addSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Integer id) {
        sectionRepository.deleteById(id);

    }

    @Override
    public String UpdateSection(int id, Section section) {

        Optional<Section> SectionFound = sectionRepository.findById(id);
        if(SectionFound.isPresent()){
            //2. Update the Section Instructor
            section.setInstructor(section.getInstructor());
            //3. Save it in the Database
            sectionRepository.save(section);
            return "Section Details Updated";
        }
        else
        {
            return "Section with user id " + id + " not found";
        }
    }
}
