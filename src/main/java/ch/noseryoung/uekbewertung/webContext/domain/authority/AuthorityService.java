package ch.noseryoung.uekbewertung.webContext.domain.authority;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class AuthorityService {

	private AuthorityRepository authorityRepository;

	/**
	 * @param authorityRepository
	 */
	@Autowired
	public AuthorityService(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	/**
	 * find authority by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Authority> findById(Long id) {
		Optional<Authority> authority = authorityRepository.findById(id);
		return authority;
	}

	/**
	 * find all authorities
	 * @return
	 */
	public List<Authority> findAll() {
		List<Authority> authorities = authorityRepository.findAll();
		return authorities;
	}

	/**
	 * tells the repository where to create a authority
	 * @param Authority
	 */
	public void save(Authority authority) {
		authorityRepository.save(authority);
	}

	/**
	 * updates the givin authority defined with id 
	 * @param newAuthority
	 * @param id
	 * @throws NoSuchElementException
	 */
	public void update(Authority newAuthority, Long id) throws NoSuchElementException {
		Optional<Authority> currentAuthority = authorityRepository.findById(id);
		if (currentAuthority.isPresent()) {
			newAuthority.setId(id);
			authorityRepository.save(newAuthority);
		} else {
			throw new NoSuchElementException(String.format("No authority with given id '%d' found", id));
		}
	}

	/**
	 * Tells the repository where to delete the authority
	 * @param id
	 */
	public void deleteById(Long id) {
		authorityRepository.deleteById(id);
	}
}
