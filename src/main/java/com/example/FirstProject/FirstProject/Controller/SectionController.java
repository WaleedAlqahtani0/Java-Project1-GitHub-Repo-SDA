package com.example.FirstProject.FirstProject.Controller;


import com.example.FirstProject.FirstProject.Entity.Section;
import com.example.FirstProject.FirstProject.Entity.User;
import com.example.FirstProject.FirstProject.Repository.SectionRepository;
import com.example.FirstProject.FirstProject.Service.Implementation.SectionImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    /*
     * REST API for User
     */
@RestController
public class SectionController {

        /*
           -------- Autowired StudentImp,SectionRepository for accessing user data
             */
    @Autowired
    private SectionImp sectionImp;

    @Autowired
    private SectionRepository sectionRepository;


        /*--------------------
       - Get a list of all sections
       - return list of all sections
      */
    @GetMapping("/sections")
    @ResponseStatus(HttpStatus.OK)
    public List<Section> getAllSection(){
        return sectionImp.getAllSection();
    }


        /*------------------
          - add a new sections
          - @RequestBody user the sections to be saved
          - @Valid to validation
          - I used try-catch to check there is not give anu error or Exception when added
            */

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

        /*----------------------
         - Delete sections with handling Exception
        */
    @DeleteMapping("/sections/delete/{id}")
    public String deleteUsers(@PathVariable int id){
        sectionImp.deleteSection(id);
        return "Section deleted";
    }

    /*----------------------
      - Update sections and I did the Exception in sectionImp class
     */

    @PutMapping("/sections/update/{id}")
    public String updateUsers(@PathVariable Integer id, @RequestBody Section section){
        return sectionImp.UpdateSection(id,section);
    }

}
