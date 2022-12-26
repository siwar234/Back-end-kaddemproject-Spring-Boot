package tn.esprit.test.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Slf4j
@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table( name ="Etudiant")
public class Etudiant  implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="idEtudiant")
    private long idEtudiant; // Clé primaire
   // long idEtudiant;
    private String  prenomE;
    //String  prenomE;
    private String nomE;
   // String nomE;
    @Enumerated(EnumType.STRING)
     private Option opt;
  //  @Temporal(TemporalType.DATE)
   // private  Date d;
    //Date d;
/*
    @ManyToOne
    private Departement dept;

    @OneToMany (mappedBy="etds")
    private List<Contrat> cont;

    @ManyToMany (mappedBy="etds")
    private List<Equipe> eq;*/


}