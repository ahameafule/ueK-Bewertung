package ch.noseryoung.uekbewertung.webContext.domain.authority;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class AuthorityServiceImpl extends ExtendedServiceImpl<Authority, AuthorityRepository> implements AuthorityService {

	public AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}
}
