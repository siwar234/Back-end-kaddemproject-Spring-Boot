package tn.esprit.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test.entity.Etudiant;
import tn.esprit.test.services.IEtudiantService;


import java.util.List;


@RestController
@RequestMapping("/EtudiantC")
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    // api de creation d´etudiant
    //http://localhost:8099/EtudiantC/addEtudiant
    //{prenomE:"Ali", nomE:"Ali"}
    // @PostMapping("/addEtudiant")
    // @ResponseBody
    // public void addEtudiant(@RequestBody Etudiant etudiant) {
    //    etudiantService.ajouter_etudiant(etudiant);
    // }

    //http://localhost:8099/EtudiantC/add-etudiant
    @PostMapping("/add-etudiant")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addEtudiant(@RequestBody Etudiant e) {
        etudiantService.addEtudiant(e);
    }

    //api de recuperation de tous les etudiants
    // http://localhost:8099/EtudiantC/etudiants
    @GetMapping("/etudiants")
    @ResponseBody
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiant();
    }

    // api de recuperation des etudiants par id
    // http://localhost:8099/EtudiantC/etudiants/2
    @GetMapping("/etudiants/{id}")
    @ResponseBody
    public Etudiant getEtudiantById(@PathVariable long id) {
        return etudiantService.retrieveById(id);
    }

    // api suppression etudiant
    // http://localhost:8099/EtudiantC/deleteEtudiant/1
    @DeleteMapping("/deleteEtudiant/{id}")
    @ResponseBody
    public void supprimerEtudiant(@PathVariable("id") long id) {
        etudiantService.deleteEtudiant(id);
    }


    // api de modification etudiant
    // http://localhost:8099/EtudiantC/updateEtudiant
    @PutMapping(value = "/updateEtudiant")
    @ResponseBody
    public void update(@RequestBody Etudiant etudiant) {
        etudiantService.update(etudiant);
    }

    // api affectation iddepart in etudiant
    @PutMapping(value="/affecter_etudiant_departement/{idEtudiant}/{idDepart}")
    @ResponseBody
    public void affecteretudiantdepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart")Long idDepart){
        etudiantService.assignEtudiantToDepartement(idEtudiant,idDepart);
    }

    // ajouter un etudiant tout en lui affectant un contrat et une equipe
   @PostMapping(value = "/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
   @ResponseBody
   public void addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant, @PathVariable("idContrat")Long idContrat ,@PathVariable("idEquipe") Long idEquipe ) {
       etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);

   }

  /*  @PostMapping("/add-assign-Etudiant/{idContrat}/{idEquipe}")
    @ResponseBody
    public Etudiant addEtudinatWithEquipeAndContrat(@RequestBody Etudiant e,@PathVariable("idContrat") Long idContrat,@PathVariable("idEquipe") Long idEquipe){
        Etudiant etudiant= etudiantService.addAndAssignEtudiantToEquipeAndContrat(e,idContrat,idEquipe);
        return etudiant;
    }*/

  /* @GetMapping(value = "/etudiants/department/{idDepart}")
    @ResponseBody
    public List<Etudiant> getAllEtudiantsbyDepartmentId(@PathVariable("idDepart")Long idDepart) {
        return etudiantService.getEtudiantsByDepartement(idDepart) ;
    }*/



}

