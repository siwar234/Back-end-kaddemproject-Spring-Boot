package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.test.entity.Departement;
import tn.esprit.test.entity.Events;
import tn.esprit.test.entity.Universite;
import tn.esprit.test.services.IUniversiteService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController

@CrossOrigin("http://localhost:4200/")
@RequestMapping("/UniversiteC")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping("/")
    public Iterable<Universite>  GetAllUniversite(){
        return iUniversiteService.retrieveAllUniversite();
    }

    @GetMapping("/UniversiteById/{universite-id}")
    public Optional< Universite > GetUniversitebyId(@PathVariable("universite-id") Long Id){
        return iUniversiteService.findUniversiteById(Id);
    }




    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Universite universite) {
        iUniversiteService.ajouterUniversite(universite);
    }


    @PutMapping("/updateUniversite/{universite-id}")
    @ResponseBody
    public void updateUniversite(@RequestBody Universite universite , @PathVariable("universite-id")Long idUniversite) {
        iUniversiteService.updateUniversite(universite,idUniversite);


    }



    @DeleteMapping("/deleteUniversite/{universite-id}")
    @ResponseBody
    public void deleteUniversite(@PathVariable("universite-id") Long universiteId ) {
        iUniversiteService.deleteUniversite(universiteId);
    }

    @PutMapping(value = "/affectationUni_dep/{Uni-id}/{dep-id}")
    public void affectationUniversiteDepartement(@PathVariable("Uni-id") Long UniId ,@PathVariable("dep-id") Long depId )
    {
        iUniversiteService.assignUniversiteToDepartement(UniId,depId);
    }

    /*@PutMapping(value = "/affectationUni_event/{Uni-id}/{Event-id}")
    public void affectationUniversiteEvent(@PathVariable("Uni-id") Long idUniversite ,@PathVariable("Event-id") Long idEvent )
    {
        iUniversiteService.assignUniversiteToEvent(idUniversite,idEvent);
    }*/


    @GetMapping(value ="/retrieveDepartementsByUniversite/{Uni-id}" )
    public Set<Departement> retrieveDepartementsByUniversite(@PathVariable("Uni-id") Long idUniversite){
        return iUniversiteService.retrieveDepartementsByUniversite(idUniversite);
    }

    @GetMapping(value ="/retrieveDEventsByUniversite/{Uni-id}" )
    public Set<Events> retrieveEventsByUniversite(@PathVariable("Uni-id") Long idUniversite){
        return iUniversiteService.retrieveEventsByUniversite(idUniversite);
    }

    @PutMapping(value = "/affectationUni_event/{Uni-id}/{Event-id}")
    public void AssignUnivToEvent( @PathVariable("Uni-id")Long idUniversite ,@PathVariable("Event-id") Long idEvent )
    {
        iUniversiteService.AssignUnivToEvent(idUniversite,idEvent);
    }
}
