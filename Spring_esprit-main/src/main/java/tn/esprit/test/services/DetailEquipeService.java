package tn.esprit.test.services;
import tn.esprit.test.entity.DetailEquipe;


import java.util.List;
import java.util.Optional;
public interface DetailEquipeService {


    public Optional<DetailEquipe> afficherDetailEquipe(Long id);
    DetailEquipe create(DetailEquipe detailEquipe);

    List<DetailEquipe> lire();

    DetailEquipe modifier(Long id,DetailEquipe detailEquipe);

    String supprimer(Long id);

    DetailEquipe retriveDetailEquipeById(Long idEquipe);

}



