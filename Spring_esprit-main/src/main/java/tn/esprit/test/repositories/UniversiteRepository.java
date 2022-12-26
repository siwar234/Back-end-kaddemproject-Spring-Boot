package tn.esprit.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test.entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
