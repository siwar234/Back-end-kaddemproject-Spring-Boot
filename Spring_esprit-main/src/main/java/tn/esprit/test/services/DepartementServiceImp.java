package tn.esprit.test.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.entity.Universite;
import tn.esprit.test.repositories.DepartemetRepository;
import tn.esprit.test.repositories.UniversiteRepository;

import java.util.List;

@Service
@Slf4j
public class DepartementServiceImp implements IDepartementService {
    @Autowired
    DepartemetRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public long addDepartement(Departement d){
        departementRepository.save(d);
        log.info("Ajouter Departement");
        return d.getIdDepart();
    }


    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement retrieveById (long id){
        return (Departement) departementRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteDepartement(long id){
        departementRepository.deleteById(id);
        log.info("Supprimer Departement");
    }

    @Override
    public Boolean update(Departement d) {
        departementRepository.save(d) ;
        return true ;
    }

    // affectation id univ lil departement
    public void assignUniversiteToDepartement(long idUniv,long idDpart ){
        Universite unv= universiteRepository.findById(idUniv).get();
        Departement d = departementRepository.findById(idDpart).get();
        d.setUniv(unv);
        departementRepository.save(d);

    }
}

