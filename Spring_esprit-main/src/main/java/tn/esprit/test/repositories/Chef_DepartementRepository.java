package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test.entity.Chef_Departement;

public interface Chef_DepartementRepository  extends JpaRepository<Chef_Departement, Long> {
}
