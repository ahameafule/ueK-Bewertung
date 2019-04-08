package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;
import ch.noseryoung.uekbewertung.webContext.domain.user.UserService;

/**
 * This class holds the endpoints is responsible for users
 * 
 * @author Joel Ahameafule
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
private UserService userService;
	
	@Autowired
	public UserController(UserService service) {
		this.userService = service;
	}

	/**
	 * This method returns the requested User
	 * 
	 * @param id Id of the requested User
	 * @return ResponseEntity with the User that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		Optional<User> user = userService.findById(id);

		HttpStatus status = (user.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(user.get(), status);
	}

	/**
	 * This method returns all users
	 * 
	 * @return
	 */
	@GetMapping({ "", "/" })
	public ResponseEntity<List<User>> getAll() {
		List<User> authorities = userService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	/**
	 * This method creates a user
	 * 
	 * @return  ResponseEntity with the user that was created
	 */
	@PostMapping({ "", "/" })
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	/**
	 * This method creates multiple users
	 * 
	 * @return  ResponseEntity with the users that were created
	 */
	@PostMapping("/bulk")
	public ResponseEntity<List<User>> create(@Valid @RequestBody List<User> users) {
		userService.save(users);

		return new ResponseEntity<>(users, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested user
	 * 
	 * @param id Id of the user that should get updated
	 * @param user User entity to which the requested course should get updated to
	 * @return ResponseEntity with the updated user
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> updateById(@PathVariable Long id, @Valid @RequestBody User user) {
		userService.update(user, id);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested user
	 * 
	 * @param id Id of the user that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
