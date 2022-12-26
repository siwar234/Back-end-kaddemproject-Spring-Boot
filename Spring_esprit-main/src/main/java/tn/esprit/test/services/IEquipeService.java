package tn.esprit.test.services;



import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import tn.esprit.test.entity.DetailEquipe;
import tn.esprit.test.entity.Equipe;


import java.util.List;
import java.util.Optional;

public interface IEquipeService {
    public Optional<Equipe> afficherEquipe(Long id);
    Equipe create(Equipe equipe);

    Page<Equipe> lire( Pageable pageable);

    Equipe modifier(Long id, Equipe equipe);

    String supprimer(Long id);

    void assignEquipeToDetail(Long equipeId, DetailEquipe detail);

    DetailEquipe retriveEquipeById(Long idEquipe);

    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);

}
