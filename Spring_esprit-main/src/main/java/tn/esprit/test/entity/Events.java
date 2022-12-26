package tn.esprit.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name ="Events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Events implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEvent")
    private Long idEvent; // Clé primaire
    @Column(name="nomEvent")

    private String nomEvent;

    private String description ;

    @Temporal(TemporalType.DATE)
    private Date dateEvent ;

    private String location ;


    private String type ;

    @JsonIgnore
    @ManyToOne
    Universite univ;}
