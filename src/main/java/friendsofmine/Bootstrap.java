package friendsofmine;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.ActiviteService;
import friendsofmine.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen on 27/02/2017.
 */
@Component
public class Bootstrap {

    @Autowired
    private InitialisationService initialisationService;

    @Autowired
    private Bootstrap bootstrap;

    @Autowired
    ActiviteService activiteService;

    @PostConstruct
    public void init(){
        initialisationService.initDonnees();
    }

    public List<Utilisateur> getUtilisateurs(){
        return initialisationService.getUtilisateurList();
    }

    public ArrayList<Activite> getActivites(){
        return initialisationService.getActiviteList();
    }

    public InitialisationService getInitialisationService() {
        return initialisationService;
    }
}
