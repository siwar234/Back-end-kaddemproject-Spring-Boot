package tn.esprit.test.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name ="Chef_Departement")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Slf4j

public class Chef_Departement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChefDpart")
    private Long idchefDepart; // Clé primaire
    private String nomchefDepart;
    private String prenomchefdepart;

    @OneToOne
    private Departement dep;

}
