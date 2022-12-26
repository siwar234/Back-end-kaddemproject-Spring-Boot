package tn.esprit.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tn.esprit.test.entity.DetailEquipe;
import tn.esprit.test.services.DetailEquipeService;


import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/DetailEquipeC")
public class DetailEquipeController {
    @Autowired
    DetailEquipeService detailEquipeServiceImp;







    @PostMapping("/addDeailEquipe")
    @ResponseBody
    public void addDeailEquipe(@RequestBody DetailEquipe detailEquipe) {
        detailEquipeServiceImp.create(detailEquipe);
    }

    @GetMapping("/detailequipes")
    @ResponseBody
    public List<DetailEquipe> getAllDetailEquipes() {
        return detailEquipeServiceImp.lire();
    }

//    @GetMapping("/detaildetailequipes/{id}")
//    @ResponseBody
//    public DetailEquipe getDetailEquipeById(@PathVariable long id) {
//        return detailEquipeServiceImp.retrieveById(id);
//    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    @ResponseBody
    public void supprimerDetailEquipe(@PathVariable("id") long id) {
        detailEquipeServiceImp.supprimer(id);
    }



    @PutMapping("/update/{id}")
    public DetailEquipe update(@PathVariable Long id, @RequestBody DetailEquipe detailEquipe){
        return detailEquipeServiceImp.modifier(id, detailEquipe);

    }
    @PutMapping("/modify-detailequipe/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetailEquipe detailequipe, @PathVariable Long id) {
        try {
            Optional<DetailEquipe> existEquipe = detailEquipeServiceImp.afficherDetailEquipe(id);
            detailequipe.setIdDetailEquipe(id);
            detailEquipeServiceImp.create(detailequipe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
