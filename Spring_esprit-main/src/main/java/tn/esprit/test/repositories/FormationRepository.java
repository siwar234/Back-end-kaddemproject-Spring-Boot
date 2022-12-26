package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
