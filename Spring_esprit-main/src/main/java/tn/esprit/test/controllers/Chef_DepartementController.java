package tn.esprit.test.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.test.entity.Chef_Departement;
import tn.esprit.test.services.IChef_DepartementService;

import java.util.List;


@RestController
@RequestMapping("/Chef_DepartementC")
@CrossOrigin(origins = "*")
public class Chef_DepartementController {
    @Autowired
    IChef_DepartementService chef_departementService;

    //http://localhost:8091/Chef_DepartementC/add-chef_departement
    @PostMapping("/add-chef_departement")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addChefDepartement(@RequestBody Chef_Departement cd) {
        chef_departementService.addChefDepartement(cd);
    }

    //api de recuperation de tous les chefs departements
    // http://localhost:8091/Chef_DepartementC/departements
    @GetMapping("/chef_departements")
    @ResponseBody
    public List<Chef_Departement> getAllChefDepartements() {
        return chef_departementService.getAllChefDepartement();
    }

    // api de recuperation des  chefs departements par id
    // http://localhost:8091/Chef_DepartementC/chef_departements/2
    @GetMapping("/chef_departements/{id}")
    @ResponseBody
    public Chef_Departement getChefDepartementById(@PathVariable long id){
        return chef_departementService.retrieveById (id);
    }

    // api suppression chef departement
    // http://localhost:8091/Chef_DepartementC/deletechef_Departement/1
    @DeleteMapping("/deletechef_Departement/{id}")
    @ResponseBody
    public void supprimerChefDepartement(@PathVariable ("id") long id){
        chef_departementService.deletechefDepartement(id);
    }

    // api de modification chef departement
    // http://localhost:8091/Chef_DepartementC/updateChef_Departement
    @PostMapping("/updateChef_Departement")
    @ResponseBody
    public void update(@RequestBody Chef_Departement chef_departement ) {
        chef_departementService.update(chef_departement) ;
    }

    // api affectation iddepart in chef
    @PostMapping(value="/affecter_depart_chef/{idDepart}/{idChefDpart}")
    @ResponseBody
    public void affecteredepartementchef(@PathVariable("idDepart") Long idDepart,@PathVariable("idChefDpart")Long idChefDpart){
        chef_departementService.assignDepartementToChefDepartement(idDepart,idChefDpart);
    }

}
