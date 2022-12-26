package tn.esprit.test.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.entity.Etudiant;
import tn.esprit.test.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public Long ajouter_User(User e);

    public User ajouter_User(User e,Long idDepart);
    public Iterable<User> retrieveAllUser();
    Optional< User > findUserById(Long id);
    User retrieveUser(Long i);

    public void deleteUser(Long id);
    User updateUser(User e);
    public void assignEtudiantDepartement( Long idEtud , Long idDep);
    public User AddAssignEtudiantToEquipeAndContrat ( User e , Long idContrat , Long idEtudiant);

    List<User> serachh(String username);

   List<User> Trier();

    public User updateEtudianttt(User e,Long iddep) ;

    Page<User> lire(Pageable pageable);

}
