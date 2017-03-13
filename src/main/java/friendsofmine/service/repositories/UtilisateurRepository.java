package friendsofmine.service.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by valen on 06/03/2017.
 */
@Component
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
}
