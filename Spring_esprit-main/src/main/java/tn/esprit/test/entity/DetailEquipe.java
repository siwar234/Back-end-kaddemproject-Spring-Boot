package tn.esprit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Slf4j
@Entity
@Table( name ="DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Long idDetailEquipe; // Clé primaire
    private Long salle;
    private String thematique;

    @OneToOne(mappedBy = "detaileq")
    @JsonIgnore
    private Equipe equipe;

}

