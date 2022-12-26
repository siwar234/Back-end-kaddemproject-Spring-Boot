package tn.esprit.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test.entity.Formation;
import tn.esprit.test.entity.User;
import tn.esprit.test.services.IFormmationService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/FormationC")
public class FormationController {



    @Autowired
    IFormmationService form;


    @GetMapping("/")
    public Iterable<Formation>  GetAllFormation(){
        return form.retrieveAllFormation();
    }
    @GetMapping("/FormationById/{formation-id}")
    public Optional< Formation > GetDepartementbyId(@PathVariable("formation-id") Long Id){
        return form.findFormation(Id);
    }
    @PostMapping("/addFormation")
    @ResponseBody
    public void addFormation(@Valid  @RequestBody Formation formation) {
        form.ajouterFormation(formation);
    }

    @PutMapping("/updateformation")
    @ResponseBody
    public void updateFormation(@RequestBody Formation formation) {
        form.updateFormation(formation);
    }

    @DeleteMapping("/deleteFormation/{formation-id}")
    @ResponseBody
    public void deleteFormation(@PathVariable("formation-id") Long formation ) {
        form.deleteFormation(formation);
    }

    @GetMapping("/FormationByetud/{formation-id}")
    public Set<User> GetformationbyId(@PathVariable("formation-id") Long Id){
        return form.getEtudiantsByFormation(Id);
    }
}
