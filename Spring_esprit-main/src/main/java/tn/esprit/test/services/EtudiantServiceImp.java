package tn.esprit.test.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.entity.Etudiant;
import tn.esprit.test.repositories.ContratRepository;
import tn.esprit.test.repositories.DepartemetRepository;
import tn.esprit.test.repositories.EquipeRepository;
import tn.esprit.test.repositories.EtudiantRepository;


import java.util.List;


@Service
@Slf4j
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    DepartemetRepository departementRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratRepository;

    @Override
    public long addEtudiant(Etudiant e) {
        return 0;
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return null;
    }

    @Override
    public Etudiant retrieveById(long id) {
        return null;
    }

    @Override
    public void deleteEtudiant(long id) {

    }

    @Override
    public Boolean update(Etudiant e) {
        return null;
    }

    @Override
    public void assignEtudiantToDepartement(long idEtudiant, long idDpart) {

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        return null;
    }

    // public long ajouter_etudiant(Etudiant e){





}



