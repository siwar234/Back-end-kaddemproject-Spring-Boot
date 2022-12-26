package tn.esprit.test.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.test.entity.Chef_Departement;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.repositories.Chef_DepartementRepository;
import tn.esprit.test.repositories.DepartemetRepository;


import java.util.List;

@Service
@Slf4j

public class Chef_DepartementServiceImp implements IChef_DepartementService {

    @Autowired
    Chef_DepartementRepository chef_departementRepository;
    @Autowired
    DepartemetRepository departementRepository;

    @Override
    public long addChefDepartement(Chef_Departement cd){
        chef_departementRepository.save(cd);
        log.info("Ajouter Chef Departement");
        return cd.getIdchefDepart();
    }


    @Override
    public List<Chef_Departement> getAllChefDepartement() {
        return chef_departementRepository.findAll();
    }

    @Override
    public Chef_Departement retrieveById (long id){
        return (Chef_Departement) chef_departementRepository.findById(id).orElse(null);
    }


    @Override
    public void deletechefDepartement(long id){
        chef_departementRepository.deleteById(id);
        log.info("Supprimer Chef Departement");
    }

    @Override
    public Boolean update(Chef_Departement cd) {
        chef_departementRepository.save(cd) ;
        return true ;
    }

    // affectation id departement lil chef
    public void assignDepartementToChefDepartement(long idDepart,long idChefDpart ){
        Departement d= departementRepository.findById(idDepart).get();
        Chef_Departement cd = chef_departementRepository.findById(idChefDpart).get();
        cd.setDep(d);
        chef_departementRepository.save(cd);

    }
}
