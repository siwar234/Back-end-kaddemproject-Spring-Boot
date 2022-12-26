package tn.esprit.test.services;


import tn.esprit.test.entity.Departement;

import java.util.List;

public interface IDepartementService {
    public long addDepartement(Departement d);
    public List<Departement> getAllDepartement() ;
    Departement  retrieveById (long id);
    public  void deleteDepartement(long id);
    public Boolean update(Departement d);
    public  void assignUniversiteToDepartement(long idUniv,long idDpart );
}
