package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen on 27/02/2017.
 */
@Service
public class InitialisationService {

    private ArrayList<Utilisateur> utilisateurList = new ArrayList<>();

    private ArrayList<Activite> activiteList = new ArrayList<>();

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ActiviteService activiteService;

    @Autowired
    private InscriptionService inscriptionService;

    private Utilisateur thom = new Utilisateur("thom", "yorke", "thom@yorke.fr", "M");
    private Utilisateur mary = new Utilisateur("mary", "yorke", "mary@yorke.fr", "F");

    private Activite randonnee = new Activite("randonnee", "descriptif", thom);
    private Activite lindyhop = new Activite("lindyhop", "descriptif1", thom);
    private Activite taekwondo = new Activite("taekwondo", "descriptif2", mary);

    private Inscription maryOnTaekwondo;
    private Inscription thomOnRandonnee;
    private Inscription thomOnLindyhop;

    public void initDonnees(){
        activiteService.saveActivite(randonnee);
        activiteService.saveActivite(lindyhop);
        activiteService.saveActivite(taekwondo);
        maryOnTaekwondo = new Inscription(mary, taekwondo, null);
        thomOnRandonnee = new Inscription(thom, randonnee, null);
        thomOnLindyhop = new Inscription(thom, lindyhop, null);
        inscriptionService.saveInscription(maryOnTaekwondo);
        inscriptionService.saveInscription(thomOnRandonnee);
        inscriptionService.saveInscription(thomOnLindyhop);

    }

    public ArrayList<Utilisateur> getUtilisateurList() {
        return utilisateurService.findAllUtilisateurs();
    }

    public ArrayList<Activite> getActiviteList() {
        return activiteService.findAllActivites();
    }

    public Utilisateur getThom() {
        return thom;
    }

    public Utilisateur getMary() {
        return mary;
    }

    public Activite getRandonnee() {
        return randonnee;
    }

    public Activite getLindyhop() {
        return lindyhop;
    }

    public Activite getTaekwondo() {
        return taekwondo;
    }

    public Inscription getMaryOnTaekwondo() {
        return maryOnTaekwondo;
    }

    public Inscription getThomOnRandonnee() {
        return thomOnRandonnee;
    }

    public Inscription getThomOnLindyhop() {
        return thomOnLindyhop;
    }
}
