package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;

import java.util.List;

public interface SectionService {


    public List<Section> getAllSection();

    public Section addSection(Section section);

    public void deleteSection(Integer id);

    public String UpdateSection(int id, Section section);
}
