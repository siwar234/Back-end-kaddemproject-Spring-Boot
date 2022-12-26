package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.User;
import tn.esprit.test.services.IContratService;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ContratC")
public class ContratController {
    @Autowired
    IContratService contratService;


    //http://localhost:8099/ContratC/add-contrat
    @PostMapping("/add-contrat")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addContrat(@RequestBody Contrat c) {
        contratService.addContrat(c);
    }

    //api de recuperation de tous les contrats
    // http://localhost:8099/ContratC/contrats
    @GetMapping("/contrats")
    @ResponseBody
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrat();
    }

    // api de recuperation des contrats par id
    // http://localhost:8099/ContratC/contrats/2
    @GetMapping("/contrats/{id}")
    @ResponseBody
    public Contrat getContratById(@PathVariable long id) {
        return contratService.retrieveById(id);
    }

    // api suppression contrat
    // http://localhost:8099/ContratC/deleteContrat/1
    @DeleteMapping("/deleteContrat/{id}")
    @ResponseBody
    public void supprimerContrat(@PathVariable("id") long id) {
        contratService.deleteContrat(id);
    }

    // api de modification contrat
    // http://localhost:8099/ContratC/updateContrat
    @PutMapping("/updateContrat")
    @ResponseBody
    public void update(@RequestBody Contrat contrat) {
        contratService.update(contrat);
    }

    // affecter contrat lil etudiant
    @PutMapping("/aff/{nomE}/{prenomE}/{idContrat}")
    public void affectContratToEtudiant(@PathVariable("idContrat")Long idContrat, @PathVariable("nomE")String nomE ,@PathVariable("prenomE") String prenomE){
        contratService.affectContratToEtudiant(idContrat,nomE,prenomE) ;

    }

   /* @PutMapping("/assign/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable String nomE, @PathVariable String prenomE){
      return contratService.affectContratToEtudiant(c,nomE,prenomE);
   } */


/*

    // calculer le nombre de contrats encore valides entre deux dates
    @GetMapping("/get/{dateDebutContrat}/{dFin}")
    @ResponseBody
    public Integer getContart(@PathVariable("dateDebutContrat") String dateDebutContrat, @PathVariable("dFin")  String dFin){
        return contratService.nbContratsValides( dateDebutContrat, dFin);

    }
*/

    @GetMapping("/search/{dateDebutContrat}")
    public Iterable<Contrat> sera(@PathVariable("dateDebutContrat") String dateDebutContrat)
    {
        return contratService.serachh(dateDebutContrat);
    }


}
