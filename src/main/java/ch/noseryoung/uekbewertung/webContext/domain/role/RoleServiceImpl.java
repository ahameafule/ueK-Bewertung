package ch.noseryoung.uekbewertung.webContext.domain.role;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role, RoleRepository> implements RoleService {

	public RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}

}
