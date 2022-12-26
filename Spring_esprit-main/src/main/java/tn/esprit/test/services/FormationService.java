package tn.esprit.test.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.Formation;
import tn.esprit.test.entity.User;
import tn.esprit.test.repositories.FormationRepository;

import java.util.Optional;
import java.util.Set;



@Service
@Slf4j
public class FormationService implements IFormmationService{


    @Autowired
    FormationRepository formationRepositorya;

    @Override
    public Long ajouterFormation(Formation d) {
        formationRepositorya.save(d);
        log.info("Ajouter Formation");
        return d.getIdformation();
    }

    @Override
    public Iterable<Formation> retrieveAllFormation() {
        return formationRepositorya.findAll();
    }

    @Override
    public Optional<Formation> findFormation(Long id) {
        return formationRepositorya.findById(id);
    }

    @Override
    public Formation retrieveFormation(Long idFormation) {
        return formationRepositorya.findById(idFormation).get();

    }

    @Override
    public void deleteFormation(Long id) {
        formationRepositorya.deleteById(id);

    }

    @Override
    public Formation updateFormation(Formation d) {
        return formationRepositorya.save(d);
    }

    @Override
    public Set<User> getEtudiantsByFormation(Long idFormation) {
        return  retrieveFormation(idFormation).getUser();
    }
}
