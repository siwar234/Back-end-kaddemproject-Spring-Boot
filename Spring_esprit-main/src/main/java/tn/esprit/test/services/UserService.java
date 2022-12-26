package tn.esprit.test.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.Departement;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.entity.User;
import tn.esprit.test.repositories.ContratRepository;
import tn.esprit.test.repositories.DepartemetRepository;
import tn.esprit.test.repositories.EquipeRepository;
import tn.esprit.test.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    UserRepository ur;

    @Autowired
    DepartemetRepository dr;

    @Autowired
    EquipeRepository eq;
    @Autowired
    ContratRepository cr;


    @Override
    public Long ajouter_User(User e) {
        return null;
    }

    @Override
    public User ajouter_User(User e, Long idDepart) {

        Departement d = dr.findById(idDepart).orElse(null);
        e.setDepartement(d);
        return ur.save(e);
    }

    @Override
    public Iterable<User> retrieveAllUser() {
        return ur.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return ur.findById(id);
    }

    @Override
    public User retrieveUser(Long i) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        ur.deleteById(id);

    }

    @Override
    public User updateUser(User e) {
        return ur.save(e);
    }

    @Override
    public void assignEtudiantDepartement(Long idEtud, Long idDep) {


        User etudiant = ur.findById(idEtud).orElse(null);
        Departement departement = dr.findById(idDep).orElse(null);
        // departement.getEtudiants().add(etudiant);
        // departementRepository.save(departement);
        etudiant.setDepartement(departement);
        ur.save(etudiant);


    }

    @Override
    public User AddAssignEtudiantToEquipeAndContrat(User e, Long idContrat, Long idEtudiant) {

        Contrat contrat = cr.findById(idContrat).orElse(null);
        Equipe equipe = eq.findById(idEtudiant).orElse(null);
        contrat.setUser(e);
        equipe.getUsers().add(e);
        return ur.save(e);
    }

    @Override
    public List<User> serachh(String username) {
        return ur.serach(username);
    }

    @Override
    public List<User> Trier() {
        return ur.Trier();
    }

    @Override
    public User updateEtudianttt(User e, Long iddep) {
        Departement d = dr.findById(iddep).orElse(null);
        e.setDepartement(d);

        return ur.save(e);
    }

    @Override
    public Page<User> lire(Pageable pageable) {

            return ur.findAll(pageable);
        }


}
