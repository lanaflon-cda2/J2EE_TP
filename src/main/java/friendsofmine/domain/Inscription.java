package friendsofmine.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by valen on 16/03/2017.
 */
@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Utilisateur participant;

    @NotNull
    @ManyToOne
    private Activite activite;

    private Date dateInscription;

    public Inscription() {
    }

    public Inscription(Utilisateur utilisateur, Activite activite, Date date) {
        this.participant = utilisateur;
        this.activite = activite;
        this.dateInscription = date;
        if(date == null){
            this.dateInscription = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public Activite getActivite() {
        return activite;
    }

    public Utilisateur getParticipant() {
        return participant;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateInscription() {
        return dateInscription;
    }
}
