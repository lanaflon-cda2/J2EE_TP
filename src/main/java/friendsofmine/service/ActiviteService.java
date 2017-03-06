package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.service.repositories.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by valen on 06/03/2017.
 */
@Service
public class ActiviteService {

    private ActiviteRepository activiteRepository;

    @Autowired
    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public void saveActivite(Activite act1) {
        if(act1 == null){
            throw new IllegalArgumentException();
        }
        activiteRepository.save(act1);
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

}
