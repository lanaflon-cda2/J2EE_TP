package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen on 27/02/2017.
 */
@Service
public class InitialisationService {

    private List<Utilisateur> utilisateurList = new ArrayList<>();

    private List<Activite> activiteList = new ArrayList<>();

    public void initDonnees(){
        utilisateurList.add(new Utilisateur("Vivies", "Valentin", "val@v.com", "M"));
        activiteList.add(new Activite("Titre", "Desc"));
        activiteList.add(new Activite("Titre", "Desc"));
        activiteList.add(new Activite("Titre", "Desc"));
        activiteList.add(new Activite("Titre", "Desc"));
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public List<Activite> getActiviteList() {
        return activiteList;
    }
}
