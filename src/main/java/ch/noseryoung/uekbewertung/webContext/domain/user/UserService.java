package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity user.
 * 
 * @author lohse
 *
 */
@Service
public class UserService {
	
	private UserRepository userRepository;

	/**
	 * @param userRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * find all users
	 * @return
	 */
	public Optional<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	/**
	 * tells the repository where to create a user
	 * @param User
	 */
	public List<User> findAll() {
		List<User> authorities = userRepository.findAll();
		return authorities;
	}

	/**
	 * tells the repository where to create a user
	 * @param User
	 */
	public void save(User user) {
		userRepository.save(user);
	}
	
	/**
	 * tells the repository where to create multiple users
	 * @param User
	 */
	public void save(List<User> users) {
		userRepository.saveAll(users);
	}

	/**
	 * updates the givin user defined with id 
	 * @param newUser
	 * @param id
	 * @throws NoSuchElementException
	 */
	public void update(User newUser, Long id) throws NoSuchElementException {
		Optional<User> currentUser = userRepository.findById(id);
		if (currentUser.isPresent()) {
			newUser.setId(id);
			userRepository.save(newUser);
		} else {
			throw new NoSuchElementException(String.format("No user with given id '%d' found", id));
		}
	}

	/**
	 * Tells the repository where to delete the user
	 * @param id
	 */
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
}
