package tn.esprit.test.services;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.entity.Events;
import tn.esprit.test.entity.Universite;
import tn.esprit.test.repositories.DepartemetRepository;
import tn.esprit.test.repositories.EventsRepository;
import tn.esprit.test.repositories.UniversiteRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
@Slf4j

public class UniversiteServiceImp  implements IUniversiteService {
    @Autowired
    UniversiteRepository universiteRepository;

    DepartemetRepository departementRepository;

    EventsRepository eventsRepository;

    public Long ajouterUniversite(Universite u) {
        universiteRepository.save(u);
        log.info("Ajouter Universite");
        return u.getIdUniv();
    }

    @Override
    public Iterable<Universite> retrieveAllUniversite() {return universiteRepository.findAll();}




    @Override
    public Optional< Universite > findUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);}

    @Override
    public void updateUniversite(Universite universite, Long UniversiteId) {
        Universite u = universiteRepository.findById(UniversiteId).get();
        u.setEmailUniv(universite.getEmailUniv());
        u.setNomUniv(universite.getNomUniv());
        u.setAdresseUniv(universite.getAdresseUniv());
        u.setNumTelUniv(universite.getNumTelUniv());
        universiteRepository.save(u);}



    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }
    public void assignUniversiteToDepartement(Long idUniversite, Long
            idDepartement){

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);

        universite.getDepart().add(departement);
        universiteRepository.save(universite);


    }
   /* @Transactional
    public void assignUniversiteToEvent(Long idUniversite, Long idEvent){

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Events event= eventsRepository.findById(idEvent).orElse(null);
        universite.getEvents().add(event);
        universiteRepository.save(universite);


    }*/

    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite){

        return retrieveDepartementsByUniversite(idUniversite)    ;}
    public Set<Events> retrieveEventsByUniversite(Long idUniversite){
        return retrieveUniversite(idUniversite).getEvent();
    }


    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate){
        return 0;
    }

    @Transactional
    public void AssignUnivToEvent( Long idUniversite , Long idEvent  ){

        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        Events events = eventsRepository.findById(idEvent).orElse(null);
        u.getEvent().add(events);


    }



}
