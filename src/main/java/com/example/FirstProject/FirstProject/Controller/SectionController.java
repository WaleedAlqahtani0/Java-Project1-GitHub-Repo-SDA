package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Service.Implementation.SectionImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private SectionImp sectionImp;

    @GetMapping("/sections")
    @ResponseStatus(HttpStatus.OK)
    public List<Section> getAllSection(){
        return sectionImp.getAllSection();
    }

    @PostMapping("/sections/add")
    public ResponseEntity<String> addSections(@RequestBody Section section) {
        try {
            sectionImp.addSection(section);
            String massage = "Sections add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Sections not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    @DeleteMapping("/sections/delete/{id}")
    public String deleteUsers(@PathVariable int id){
        sectionImp.deleteSection(id);
        return "Section deleted";
    }

    //// Update

    @PutMapping("/sections/update/{id}")
    public String updateUsers(@PathVariable Integer id, @RequestBody Section section){
        return sectionImp.UpdateSection(id,section);
    }

}
