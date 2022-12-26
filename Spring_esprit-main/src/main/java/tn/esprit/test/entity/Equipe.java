package tn.esprit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
@Table( name ="Equipe")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Builder
@Slf4j
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private long idEquipe; // Clé primaire
    private String nomEquipe;
    private String image;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Niveau niveau;

    @OneToOne
    @JsonIgnore
    private DetailEquipe detaileq;


    @ManyToMany
    @JsonIgnore
    private List <User> users;


}

