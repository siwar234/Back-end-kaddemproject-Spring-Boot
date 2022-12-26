package tn.esprit.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String username;


    @Size(max = 50)
    @Email
    private String email;


    @Size(max = 120)
    private String password;

    private String opt;


    @OneToMany( mappedBy="user")
    private Set<Contrat> contrat;

    @ManyToMany(mappedBy = "users")
    private Set<Equipe> equipes;

    @ManyToOne
    Departement departement;

    @ManyToOne
    Formation formation;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }
public Long getId()
{
    return  id;
}

    public Object getCreatedAt() {
        return null;
    }

}