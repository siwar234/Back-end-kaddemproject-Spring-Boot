package tn.esprit.test.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);
    Page<Equipe> findAll(Pageable pageable);
}

