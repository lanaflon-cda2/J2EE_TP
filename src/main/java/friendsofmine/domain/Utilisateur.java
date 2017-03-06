package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by valen on 27/02/2017.
 */
public class Utilisateur {

    @NotNull
    @NotEmpty
    private String nom;

    @NotNull
    @NotEmpty
    private String prenom;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "M|F")
    private String genre;

    private Date date;

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
}
