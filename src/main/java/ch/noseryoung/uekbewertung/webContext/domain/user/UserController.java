package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import ch.noseryoung.uekbewertung.webContext.domain.user.dto.UserDTO;
import ch.noseryoung.uekbewertung.webContext.domain.user.dto.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds the endpoints is responsible for users
 * 
 * @author Joel Ahameafule
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "AuthorityController"
	)
public class UserController {
	
private UserService userService;
private UserMapper userMapper;
	
	@Autowired
	public UserController(UserService service, UserMapper userMapper) {
		this.userService = service;
		this.userMapper = userMapper;
	}

	/**
	 * This method returns the requested User
	 * 
	 * @param id Id of the requested User
	 * @return ResponseEntity with the User that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested user",
			response = User.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested user",
					required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
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
	@ApiOperation(
			value = "This endpoint returns all users",
			response = User.class
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@GetMapping({ "", "/" })
	public ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAllByOrderByJoinYear();
		System.out.println(users);
		System.out.println(userMapper.usersToUserDTOs(users));
		return new ResponseEntity<>(userMapper.usersToUserDTOs(users), HttpStatus.OK);
	}
	
	/**
	 * This method returns all apprentices
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint returns all apprentices",
			response = User.class
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@GetMapping("/apprentices" )
	public ResponseEntity<List<UserDTO>> getAllApprentices() {
		List<User> users = userService.findAllApprentices();
		return new ResponseEntity<>(userMapper.usersToUserDTOs(users), HttpStatus.OK);
	}
	
	/**
	 * This method returns all users
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint returns all course leaders",
			response = User.class
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@GetMapping("/course-leaders" )
	public ResponseEntity<List<UserDTO>> getAllCourseLeaders() {
		List<User> users = userService.findAllCourseLeaders();
		return new ResponseEntity<>(userMapper.usersToUserDTOs(users), HttpStatus.OK);
	}

	/**
	 * This method creates a user
	 * 
	 * @return  ResponseEntity with the user that was created
	 */
	@ApiOperation(
			value = "This endpoint creates a user",
			response = User.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The user to be created",
				required = true
			) }
		)
	
	@PreAuthorize("hasAuthority('MANAGE')")
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
	@ApiOperation(
			value = "This endpoint creates multiple users",
			response = User.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The users which will be created",
				required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
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
	@ApiOperation(
			value = "This endpoint updates the requested user",
			response = User.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The logged in user",
				required = true
				) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
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
	@ApiOperation(
			value = "This endpoint deletes the requested user",
			response = User.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested user",
					required = true
			) }
		)
	@PreAuthorize("hasAuthority('MANAGE')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
