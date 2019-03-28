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

	public Optional<Authority> findById(Long id) {
		Optional<Authority> authority = authorityRepository.findById(id);
		return authority;
	}

	public List<Authority> findAll() {
		List<Authority> authorities = authorityRepository.findAll();
		return authorities;
	}

	public void save(Authority authority) {
		authorityRepository.save(authority);
	}

	public void update(Authority newAuthority, Long id) throws NoSuchElementException {
		Optional<Authority> currentAuthority = authorityRepository.findById(id);
		if (currentAuthority.isPresent()) {
			newAuthority.setId(id);
			authorityRepository.save(newAuthority);
		} else {
			throw new NoSuchElementException(String.format("No authority with given id '%d' found", id));
		}
	}

	public void deleteById(Long id) {
		authorityRepository.deleteById(id);
	}
}
