package ch.noseryoung.uekbewertung.webContext.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import ch.noseryoung.uekbewertung.config.generic.ExtendedService;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 * 
 * @author Moritz Lauper
 *
 */
public interface UserService extends UserDetailsService, ExtendedService<User> {
	
}
