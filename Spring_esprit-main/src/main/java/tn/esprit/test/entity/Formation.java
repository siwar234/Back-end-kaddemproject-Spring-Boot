package tn.esprit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;



@Entity
@Table( name ="Formation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idformation")
    private Long idformation; // Clé primaire
    @NotBlank
    private String nomFomrmation;
    @NotBlank
    private String lieu;
    @NotBlank
    private String sujet;
    @NotBlank
    private String description;

    @NotBlank
    /*@Temporal(TemporalType.DATE)*/
    private String datedebut;
    @NotBlank
    /*@Temporal(TemporalType.DATE)*/
    private String datefin;



    @OneToMany( mappedBy="formation")
    @JsonIgnore
    private Set<User> user;


}
