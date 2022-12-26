package tn.esprit.test.services;

import tn.esprit.test.entity.Contrat;
import tn.esprit.test.entity.User;

import java.util.Date;
import java.util.List;

public interface IContratService {
    public long addContrat(Contrat c);
    public List <Contrat> getAllContrat() ;
    Contrat  retrieveById (long id);
    public  void deleteContrat(long id);
    public Boolean update(Contrat c);
    public  Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE);
    public Integer nbContratsValides(Date startDate, Date endDate);
   //public Contrat affectContratToEtudiant(Contrat c,  String nomE,String prenomE);
   List<Contrat> serachh(String dateDebutContrat);
}
