package ch.noseryoung.uekbewertung.webContext.domain.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
