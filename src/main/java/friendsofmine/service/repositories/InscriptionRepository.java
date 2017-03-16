package friendsofmine.service.repositories;

import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by valen on 16/03/2017.
 */
@Repository
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {
}
