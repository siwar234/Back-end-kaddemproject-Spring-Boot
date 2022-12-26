package tn.esprit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table( name ="Contrat")
@Getter
@Setter
@NoArgsConstructor /*génère un constructeur vide */
@AllArgsConstructor /* genere un constrcuteur avec tout les attruibiute */
@ToString
public class Contrat implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idContart")
    private long idContrat; // Clé primaire
   /* @Temporal(TemporalType.DATE)*/
    private String datedeb;
    /*@Temporal(TemporalType.DATE)*/
    private String datefin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;
    private long montantContrat;

    @JsonIgnore
    @ManyToOne
    User user;

}




