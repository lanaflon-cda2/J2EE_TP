package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by valen on 27/02/2017.
 */
@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @NotNull
    private String titre;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_utilisateur")
    @NotNull
    private Utilisateur utilisateur;

    public Activite() {
    }

    public Activite(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Activite(String titre, String descriptif, Utilisateur utilisateur) {
        this.titre = titre;
        this.description = descriptif;
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
