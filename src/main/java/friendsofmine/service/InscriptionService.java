package friendsofmine.service;

import friendsofmine.domain.Inscription;
import friendsofmine.service.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
