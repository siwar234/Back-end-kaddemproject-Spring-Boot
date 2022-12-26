package tn.esprit.test.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import tn.esprit.test.entity.DetailEquipe;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.repositories.EquipeRepository;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;

@Service
@Slf4j

public class EquipeServiceImp implements IEquipeService{
    @Autowired
     EquipeRepository equipeRepository;
    @Override
    public Optional<Equipe> afficherEquipe(Long id) {

        Equipe equipe = equipeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                        "equipe with Id" + id + " does not exist"
                )
        );
        return equipeRepository.findById(id);
    }
    @Override
    public Equipe create(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Page<Equipe> lire(Pageable pageable) {
        return equipeRepository.findAll(pageable);
    }



    @Override
    public Equipe modifier(Long id, Equipe equipe) {
        return equipeRepository.findById(id).map(e->
        {
            e.setNiveau(e.getNiveau());
            e.setNomEquipe(e.getNomEquipe());
            e.setDetaileq(e.getDetaileq());
            e.setImage(e.getImage());
            return equipeRepository.save(e);




        }).orElseThrow(()-> new RuntimeException("equipe non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        equipeRepository.deleteById(id);
        return "equipe supprimé";    }

    @Override
    public void assignEquipeToDetail(Long equipeId, DetailEquipe detail) {
        Equipe e = equipeRepository.findById(equipeId).get();
        e.setDetaileq(detail);
        equipeRepository.save(e);
    }

    @Override
    public DetailEquipe retriveEquipeById(Long idEquipe) {
        return equipeRepository.findById(idEquipe).get().getDetaileq();
    }

    @Override
    public Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable) {
        return equipeRepository.findAllByNomEquipeContaining(nomEquipe, pageable);
    }



}
