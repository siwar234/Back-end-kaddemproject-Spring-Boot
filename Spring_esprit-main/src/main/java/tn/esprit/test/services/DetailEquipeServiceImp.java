package tn.esprit.test.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.DetailEquipe;
import tn.esprit.test.repositories.DetailEquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DetailEquipeServiceImp implements DetailEquipeService{
    @Autowired
    private final DetailEquipeRepository detailEquipeRepository;

    @Override
    public Optional<DetailEquipe> afficherDetailEquipe(Long id) {

        DetailEquipe equipe = detailEquipeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                        "detail with Id" + id + " does not exist"
                )
        );
        return detailEquipeRepository.findById(id);
    }

    @Override
    public DetailEquipe create(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> lire() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe modifier(Long id, DetailEquipe detailEquipe) {
        return detailEquipeRepository.findById(id).map( d ->
        {
            d.setSalle(d.getSalle());
            d.setThematique(d.getThematique());
            d.setEquipe(d.getEquipe());
            return detailEquipeRepository.save(d);
        }).orElseThrow(()-> new RuntimeException("detail equipe non trouvé"));
    }


    @Override
    public String supprimer(Long id) {
        detailEquipeRepository.deleteById(id);
        return "detail equipe supprimé";    }

    @Override
    public DetailEquipe retriveDetailEquipeById(Long idEquipe) {
        return detailEquipeRepository.findById(idEquipe).get();
    }

}
