package tn.esprit.test.services;

import tn.esprit.test.entity.Chef_Departement;

import java.util.List;

public interface IChef_DepartementService {
    long addChefDepartement(Chef_Departement cd);

    public List<Chef_Departement> getAllChefDepartement() ;
    public Chef_Departement retrieveById (long id);
    public void deletechefDepartement(long id);
    public Boolean update(Chef_Departement cd);
    public  void assignDepartementToChefDepartement(long idDepart,long idChefDpart );
}
