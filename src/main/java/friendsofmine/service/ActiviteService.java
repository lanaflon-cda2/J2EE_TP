package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.repositories.ActiviteRepository;
import friendsofmine.service.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen on 06/03/2017.
 */
@Service
public class ActiviteService {

    private ActiviteRepository activiteRepository;

    private UtilisateurRepository utilisateurRepository;

    private Utilisateur utilisateur = new Utilisateur("steven", "gerrard", "email@email.com", "M");

    @Autowired
    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    @Autowired
    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Activite saveActivite(Activite act1) {
        if(act1 == null){
            throw new IllegalArgumentException();
        }
        Utilisateur u = act1.getUtilisateur();
        if(u != null){
            u.addActivites(act1);
            utilisateurRepository.save(u);
        }
        return activiteRepository.save(act1);
    }

    public Activite findOneActivite(long id) {
        return activiteRepository.findOne(id);
    }

    public long countActivite() {
        return activiteRepository.count();
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public ArrayList<Activite> findAllActivites(){
        ArrayList<Activite> list = new ArrayList<>();
        for(Activite act : activiteRepository.findAll(new Sort(Sort.Direction.ASC, "titre"))){
            list.add(act);
        }
        return list;
    }

}
