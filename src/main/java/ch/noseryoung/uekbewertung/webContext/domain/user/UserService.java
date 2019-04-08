package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

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
		List<User> users = userRepository.findAll();
		return users;
	}

	/**
	 * tells the repository where to create a user
	 * @param User
	 */
	public void save(User user) {
		user.setCreationdate(new Date());
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
	
	/**
	 * deletes users after one year
	 * @param id
	 * @return
	 */
	public void deleteOldUsers(Date dateToCheck) {
		
		List<User> users = userRepository.findAll();
		
		for (User user : users) {
			boolean isTrainer = false;
			
			for (Role role : user.getRoles()) {
				/**
				 * The user will not be deleted if he has the role "trainer"
				 */
				if(role.getName().equals("trainer")) {
					isTrainer = true;
				}
			}
			
			if(!isTrainer) {
				if(user.getCreationdate().before(dateToCheck)) {
					userRepository.delete(user);
				}
			}
		}
	}
	
}
