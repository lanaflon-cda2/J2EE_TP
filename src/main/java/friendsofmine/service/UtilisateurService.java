package friendsofmine.service;


import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
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
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findOneUtilisateur(long id) {
        return utilisateurRepository.findOne(id);
    }

    public long countUtilisateur() {
        return utilisateurRepository.count();
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public ArrayList<Utilisateur> findAllUtilisateurs(){
        ArrayList<Utilisateur> list = new ArrayList<>();
        for(Utilisateur utilisateur : utilisateurRepository.findAll(new Sort(Sort.Direction.ASC, "nom"))){
            list.add(utilisateur);
        }
        return list;
    }

    public void deleteUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.delete(utilisateur);
    }

}
