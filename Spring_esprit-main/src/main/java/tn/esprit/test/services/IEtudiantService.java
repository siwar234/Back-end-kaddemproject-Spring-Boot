package tn.esprit.test.services;

import tn.esprit.test.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
   // public long ajouter_etudiant(Etudiant e);
     public long addEtudiant(Etudiant e);
     public List <Etudiant> getAllEtudiant() ;
     Etudiant  retrieveById (long id);
    public  void deleteEtudiant(long id);
    public Boolean update(Etudiant e);
    public  void assignEtudiantToDepartement(long idEtudiant,long idDpart );
  // public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);

   // List<Etudiant> getEtudiantsByDepartement (Long idDepartement);




}
