package friendsofmine.service;

import friendsofmine.domain.Activite;
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
    UtilisateurService utilisateurService;

    @Autowired
    ActiviteService activiteService;

    private Utilisateur thom = new Utilisateur("thom", "yorke", "thom@yorke.fr", "M");
    private Utilisateur mary = new Utilisateur("mary", "yorke", "mary@yorke.fr", "F");

    private Activite randonnee = new Activite("randonnee", "descriptif", thom);
    private Activite lindyhop = new Activite("lindyhop", "descriptif1", thom);
    private Activite taekwondo = new Activite("taekwondo", "descriptif2", mary);

    public void initDonnees(){
        activiteService.saveActivite(randonnee);
        activiteService.saveActivite(lindyhop);
        activiteService.saveActivite(taekwondo);
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
}
