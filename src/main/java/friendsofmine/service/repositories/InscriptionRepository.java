package friendsofmine.service.repositories;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valen on 16/03/2017.
 */
@Repository
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long>{

    Page<Inscription> findByParticipantNomAndActiviteTitreAllIgnoreCase(String nom, String titre, Pageable pageable);
    Page<Inscription> findByParticipantNomAllIgnoreCase(String nom, Pageable pageable);
    Page<Inscription> findByActiviteTitreAllIgnoreCase(String titre, Pageable pageable);

}
