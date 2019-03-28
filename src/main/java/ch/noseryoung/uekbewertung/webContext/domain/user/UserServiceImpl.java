package ch.noseryoung.uekbewertung.webContext.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * 
 * @author Moritz Lauper
 */
@Service
public class UserServiceImpl extends ExtendedServiceImpl<User, UserRepository> implements UserService {
		
	/**
	 * @param repository
	 */
	@Autowired
	UserServiceImpl(UserRepository repository) {
		super(repository);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
