package tn.esprit.test.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.Etudiant;
import tn.esprit.test.entity.User;
import tn.esprit.test.repositories.ContratRepository;
import tn.esprit.test.repositories.EtudiantRepository;
import tn.esprit.test.repositories.UserRepository;


import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ContratServiceImp implements IContratService {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    UserRepository etudiantRepository;

    @Override
    public long addContrat(Contrat c){
        contratRepository.save(c);
        log.info("Ajouter Contrat");
        return c.getIdContrat();
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveById (long id){
        return (Contrat) contratRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContrat(long id){
        contratRepository.deleteById(id);
        log.info("Supprimer Contrat");
    }

    @Override
    public Boolean update(Contrat c) {
        contratRepository.save(c) ;
        return true ;
    }

    @Override
    public Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE) {
        return null;
    }

    //
  /* @Override
   public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       Etudiant e= etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
       int nbrContratActifs=0;
       if(e!=null){
           for (Contrat c : e.getCont()){
               if (c.getArchive().equals(false)) {
                   nbrContratActifs++;
               }
           }
           if(nbrContratActifs<5){
              // ce.setEtudiant_contr(e);
               ce.setEtds(e);
           }
       }
       return contratRepository.save(ce);
   }*/

    // api affecter contrat to etudiant


   /* public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e= etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        int nbrContratActifs=0;
        if(e!=null){
            for (Contrat c : e.getCont()){
                if (c.getArchive().equals(false)) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                // ce.setEtudiant_contr(e);
                ce.setEtds(e);
            }
        }
        return contratRepository.save(ce);
    }*/

    // calculer le nombre de contrats encore valides entre deux dates
  public Integer nbContratsValides(Date startDate, Date endDate) {
       return contratRepository.nbContratsValides(startDate,endDate);
   }

    @Override
    public List<Contrat> serachh(String dateDebutContrat) {
        return contratRepository.serach(dateDebutContrat);
    }


}
