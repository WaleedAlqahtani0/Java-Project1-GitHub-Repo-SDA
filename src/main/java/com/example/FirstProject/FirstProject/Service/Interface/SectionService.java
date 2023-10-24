package com.example.FirstProject.FirstProject.Service.Interface;

import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;

import java.util.List;

/*

  The SectionService is an interface that defines the methods that are available to perform operations on Section entities.

 */
public interface SectionService {
     /*

     List of methods to show all Section, add , delete and update Section.

    */


    public List<Section> getAllSection();

    public Section addSection(Section section);

    public void deleteSection(Integer id);

    public String UpdateSection(int id, Section section);
}
