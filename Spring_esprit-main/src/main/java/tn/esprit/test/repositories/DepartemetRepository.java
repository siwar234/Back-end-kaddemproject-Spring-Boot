package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test.entity.Departement;

public interface DepartemetRepository extends JpaRepository<Departement, Long> {

}
