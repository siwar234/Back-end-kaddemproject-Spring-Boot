package tn.esprit.test.services;

import tn.esprit.test.entity.Formation;
import tn.esprit.test.entity.User;

import java.util.Optional;
import java.util.Set;

public interface IFormmationService {

    public Long ajouterFormation(Formation d);
    public Iterable<Formation> retrieveAllFormation();
    Optional< Formation> findFormation(Long id);
    public Formation retrieveFormation(Long idFormation);

    public void deleteFormation(Long id);
    public Formation updateFormation(Formation d);
    public Set<User> getEtudiantsByFormation (Long idFormation);
}
