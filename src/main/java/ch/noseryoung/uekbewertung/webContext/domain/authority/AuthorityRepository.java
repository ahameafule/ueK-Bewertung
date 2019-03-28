package ch.noseryoung.uekbewertung.webContext.domain.authority;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

}
