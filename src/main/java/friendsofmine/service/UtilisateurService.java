package friendsofmine.service;


import friendsofmine.domain.Utilisateur;
import friendsofmine.service.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
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
}
