package ch.noseryoung.uekbewertung.webContext.domain.role;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity role.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

}
