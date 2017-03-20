package friendsofmine.service;

import friendsofmine.domain.Inscription;
import friendsofmine.service.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen on 16/03/2017.
 */
@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public Inscription findOneInscription(long id) {
        return inscriptionRepository.findOne(id);
    }

    public long countInscription() {
        return inscriptionRepository.count();
    }

    public InscriptionRepository getInscriptionRepository() {
        return inscriptionRepository;
    }

    public void deleteInscription(Inscription inscription){
        inscriptionRepository.delete(inscription);
    }

    public Page<Inscription> findByUtilisateurActivite(String nom, String titre, Pageable pageable){
        return inscriptionRepository.findByParticipantNomAndActiviteTitreAllIgnoreCase(nom, titre, pageable);
    }

    public Page<Inscription> findByUtilisateur(String nom, Pageable pageable){
        return inscriptionRepository.findByParticipantNomAllIgnoreCase(nom, pageable);
    }

    public Page<Inscription> findByActivite(String titre, Pageable pageable){
        return inscriptionRepository.findByActiviteTitreAllIgnoreCase(titre, pageable);
    }

    public Page<Inscription> findAll(Pageable pageable){
        return inscriptionRepository.findAll(pageable);
    }

}
