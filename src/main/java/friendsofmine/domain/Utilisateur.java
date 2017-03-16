package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by valen on 27/02/2017.
 */
@Entity
public class Utilisateur {

    public Utilisateur() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String nom;

    @NotNull
    @Size(min = 1, max = 20)
    private String prenom;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "M|F")
    private String genre;

    private Date date;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Activite> activites = new HashSet<>();

    public Utilisateur(String nom, String prenom, String email, String genre, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.genre = genre;
        this.date = date;
    }

    public Utilisateur(String nom, String prenom, String email, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDate() {
        return date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Activite> getActivites() {
        return activites;
    }

    public void setActivites(Set<Activite> activites) {
        this.activites = activites;
    }

    public void addActivites(Activite activite){
        activites.add(activite);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Utilisateur utilisateur = (Utilisateur) obj;
        return this.id.equals(utilisateur.getId());
    }
}
