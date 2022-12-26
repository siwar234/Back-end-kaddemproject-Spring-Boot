package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.entity.User;
import tn.esprit.test.services.IUserService;

import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/UserC")
public class UserController {

    @Autowired
    IUserService us;



    // http://localhost:8089/Etudiant/add-Etudiant
    //{prenomE:"Ali", nomE:"Ali"}
    @GetMapping("/")
    public Iterable<User>  GetAllUser(){
        return us.retrieveAllUser();
    }
    @GetMapping("/EtudiantById/{etudiant-id}")
    public Optional< User > GetUserbyId(@PathVariable("etudiant-id") Long Id){
        return us.findUserById(Id);
    }
    @PostMapping("/addEtudiant")
    @ResponseBody
    public void addEtudiant(@RequestBody User etudiant) {
        us.ajouter_User(etudiant);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public void updateEtudiant(@RequestBody User etudiant) {
        us.updateUser(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{etudiant-id}")
    @ResponseBody
    public void deleteEtudiant(@PathVariable("etudiant-id") Long etudiantId ) {
        us.deleteUser(etudiantId);
    }
    @PutMapping(value = "/affectationEtudiant_dep/{etud-id}/{dep-id}")
    public void affectationEtudiantDepartement(@PathVariable("etud-id") Long etudId ,@PathVariable("dep-id") Long depId )
    {
        us.assignEtudiantDepartement(etudId,depId);
    }

    @PostMapping (value = "/affectationEtudiant_contrat_equipe/{contrat-id}/{equipe-id}")
    @ResponseBody
    public User affectationEtudiantContratEquipe( @RequestBody User etudiant ,@PathVariable("contrat-id") Long contratId ,@PathVariable("equipe-id") Long equipeId )
    {
        User etudiant1 = us.AddAssignEtudiantToEquipeAndContrat(etudiant,contratId,equipeId );
        return etudiant1;
    }

    @GetMapping("/search/{username}")
    public Iterable<User> sera(@PathVariable("username") String username)
    {
        return us.serachh(username);
    }

    @GetMapping("/Trier")
    public Iterable<User> Tri()
    {
        return us.Trier();
    }


    @PostMapping("/addEtudiantt/{idDepartement}")
    @ResponseBody
    public void addEtudiantt(@RequestBody User etudiant,@PathVariable("idDepartement") Long idDepartement) {
        us.ajouter_User(etudiant,idDepartement);
    }


    @PutMapping("/updateEtudiantt/{idDepartement}")
    @ResponseBody
    public void updateEtudiant(@RequestBody User etudiant,@PathVariable("idDepartement") Long idDepartement) {
        us.updateEtudianttt(etudiant,idDepartement);
    }
/*

    @PutMapping(value = "/affectationEtudiant_formation/{etud-id}/{for-id}")
    public void affectationEtudiantFormation(@PathVariable("etud-id") Long etudId ,@PathVariable("for-id") Long forId )
    {
        us.assignEtudiantFormation(etudId,forId);
    }

*/


    @GetMapping("/userall")
    @ResponseBody
    public Page<User> getAllEquipe(Pageable pageable) {
        return us.lire(pageable);
    }
}
