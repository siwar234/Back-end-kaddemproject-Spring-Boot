package tn.esprit.test.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table( name ="Universite")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Slf4j
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private long idUniv; // Clé primaire
    private String nomUniv;

    private String adresseUniv ;

    private String emailUniv ;

    private String numTelUniv ;

    public Set<Events> getEvent() {
        return event;
    }

    public void setEvent(Set<Events> event) {
        this.event = event;
    }

    @OneToMany
    private List<Departement> depart;
    @OneToMany( mappedBy="univ")
    private Set<Events> event;

    public long getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(long idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }

    public String getAdresseUniv() {
        return adresseUniv;
    }

    public void setAdresseUniv(String adresseUniv) {
        this.adresseUniv = adresseUniv;
    }

    public String getEmailUniv() {
        return emailUniv;
    }

    public void setEmailUniv(String emailUniv) {
        this.emailUniv = emailUniv;
    }

    public String getNumTelUniv() {
        return numTelUniv;
    }

    public void setNumTelUniv(String numTelUniv) {
        this.numTelUniv = numTelUniv;
    }

    public List<Departement> getDepart() {
        return depart;
    }

    public void setDepart(List<Departement> depart) {
        this.depart = depart;
    }
}





