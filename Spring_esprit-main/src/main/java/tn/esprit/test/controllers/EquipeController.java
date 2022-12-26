package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;

import tn.esprit.test.entity.DetailEquipe;
import tn.esprit.test.entity.Equipe;
import tn.esprit.test.repositories.EquipeRepository;
import tn.esprit.test.services.DetailEquipeServiceImp;
import tn.esprit.test.services.EquipeServiceImp;


import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")

@RestController
@RequestMapping("/Equipe")

public class EquipeController {
    @Autowired
    EquipeServiceImp equipeService;

    @Autowired
    DetailEquipeServiceImp detailEquipeService;
    @Autowired
    private EquipeRepository equipeRepository;

    @PostMapping("/add-equipe")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addEquipe(@RequestBody Equipe eq) {
        equipeService.create(eq);
    }

    @GetMapping("/equipe")
    @ResponseBody
    public Page<Equipe> getAllEquipe(Pageable pageable) {
        return equipeService.lire(pageable);
    }

//    @GetMapping("/equipes/{id}")
//    @ResponseBody
//    public Equipe getEquipeById(@PathVariable long id){
//        return equipeService.retrieveById (id);
//    }

    @DeleteMapping("/deleteEquipe/{id}")
    @ResponseBody
    public void supprimerEquipe(@PathVariable("id") long id){
        equipeService.supprimer(id);
    }




   /* @PutMapping("/updateEquipe")
    @ResponseBody
    public void update(@RequestBody Equipe equipe) {
        equipeService.update(equipe) ;
    } */
//   @PutMapping("/modify-equipe/{idEquipe}")
//   @ResponseBody
//   public Equipe modifyEquipe(@RequestBody Long idEquipe, Equipe equipe) {
//       return    equipeService.modifier(idEquipe,equipe);
//
//
//   }


    @PutMapping("/modify-equipe/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Equipe equipe, @PathVariable Long id) {
        try {
            Optional<Equipe> existEquipe = equipeService.afficherEquipe(id);
            equipe.setIdEquipe(id);
            equipeService.create(equipe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("addDetails/{id}")
    public void saveDetailsTeam(
            @Valid @RequestBody DetailEquipe detailEquipe, @PathVariable Long id)
    {
        detailEquipeService.create(detailEquipe);

        equipeService.assignEquipeToDetail(id,detailEquipe);

    }
    @GetMapping("/search/{nomEquipe}")
    public ResponseEntity<?> searchByNomEquipe(@PathVariable String nomEquipe, @PageableDefault(sort = "nomEquipe", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Equipe> equipePage = equipeService.findAllByNomEquipeContaining(nomEquipe, pageable);

        return new ResponseEntity<>(equipePage, HttpStatus.OK);
    }


}
