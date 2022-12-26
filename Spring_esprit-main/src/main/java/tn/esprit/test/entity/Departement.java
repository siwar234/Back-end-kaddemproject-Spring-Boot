package tn.esprit.test.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table( name ="Departement")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Slf4j
public class Departement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDpart")
    private Long idDepart; // Clé primaire
    private String nomDepart;
    private String description;
    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private List<User> etds;

    @ManyToOne
    @JsonIgnore
    private Universite univ;



}
