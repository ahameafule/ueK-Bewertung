package ch.noseryoung.uekbewertung.webContext.domain.user;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 *
 * @author Yves Kaufmann
 */
@Repository
interface UserRepository extends ExtendedJpaRepository<User> {
	
}
