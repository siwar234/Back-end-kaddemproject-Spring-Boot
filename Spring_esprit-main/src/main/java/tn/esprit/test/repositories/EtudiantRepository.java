package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    // List<Etudiant> findAllByDepartements_IdDepartement(Long idDepart) ;
    /*public List<Etudiant>  findEtudiantByDepartement_IdDepart(Long idDepart );*/
    // @Query("Select e From Etudiant e where e.nomE= nomE and e.prenemE=prenomE")
    public Etudiant findByNomEAndPrenomE(String nomE, String prenomE);

   // public Etudiant findByNomEAndPrenomE(@Param("nomE") String nomE,@Param("preneomE") String prenomE);
}

