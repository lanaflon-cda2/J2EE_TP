package friendsofmine.service.repositories;

import friendsofmine.domain.Activite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by valen on 06/03/2017.
 */
@Component
public interface ActiviteRepository extends PagingAndSortingRepository<Activite, Long> {

}
