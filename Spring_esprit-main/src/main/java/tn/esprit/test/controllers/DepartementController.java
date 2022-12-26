package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.services.IDepartementService;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/DepartementC")
public class DepartementController {
    @Autowired
    IDepartementService departementService;

    //http://localhost:8091/DepartementC/add-departement
    @PostMapping("/add-departement")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addDepartement(@RequestBody Departement d) {
        departementService.addDepartement(d);
    }

    //api de recuperation de tous les departements
    // http://localhost:8091/DepartementC/departements
    @GetMapping("/departements")
    @ResponseBody
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartement();
    }

    // api de recuperation des departements par id
    // http://localhost:8091/DepartementC/departements/2
    @GetMapping("/departements/{id}")
    @ResponseBody
    public Departement getDepartementById(@PathVariable long id){
        return departementService.retrieveById (id);
    }

    // api suppression departement
    // http://localhost:8091/DepartementC/deleteDepartement/1
    @DeleteMapping("/deleteDepartement/{id}")
    @ResponseBody
    public void supprimerDepartement(@PathVariable ("id") long id){
        departementService.deleteDepartement(id);
    }

    // api de modification departement
    // http://localhost:8091/DepartementC/updateDepartement
    @PutMapping("/updateDepartement")
    @ResponseBody
    public void update(@RequestBody Departement departement ) {
        departementService.update(departement) ;
    }

    // api affectation iduniversite in departement
    @PutMapping(value="/affecter_universite_departement/{idUniv}/{idDepart}")
    @ResponseBody
    public void affecteruniversitedepartement(@PathVariable("idUniv") Long idUniv,@PathVariable("idDepart")Long idDepart) {
        departementService.assignUniversiteToDepartement(idUniv,idDepart);
    }


}
