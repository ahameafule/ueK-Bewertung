package ch.noseryoung.uekbewertung.webContext.domain.authority;

import java.util.List;

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


/**
 * This class holds all REST endpoints targeted towards the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

	private AuthorityService authorityService;
	
	/**
	 * 
	 * @param authorityService
	 */
	@Autowired
	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	/**
	 * This method returns the requested authority
	 *
	 * @param  id Id of the requested authority
	 * @return    ResponseEntity with the authority that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Authority> getById(@PathVariable Long id) {
		Authority authority =  authorityService.findById(id).get();
		return new ResponseEntity<>(authority, HttpStatus.OK);
	}
	
	/**
	 * This method returns all authorities
	 * 
	 * @return
	 */
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Authority>> getAll() {
		List<Authority> authorities = authorityService.findAll();
		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}
	
	/**
	 * This method creates an authority
	 *
	 * @return ResponseEntity with the authority that was created
	 */
	@PostMapping({ "", "/" })
	public ResponseEntity<Authority> create(@Valid @RequestBody Authority authority) {
		authorityService.save(authority);
		return new ResponseEntity<>(authority, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested authority
	 *
	 * @param  id   Id of the authority that should get updated
	 * @param  authority authority entity to which the requested authority should get updated to
	 * @return      ResponseEntity with the updated authority
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Authority> updateById(@PathVariable Long id, @Valid @RequestBody Authority authority) {
		authorityService.update(authority);
		return new ResponseEntity<>(authority, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested authority
	 *
	 * @param  id Id of the authority that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		authorityService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
