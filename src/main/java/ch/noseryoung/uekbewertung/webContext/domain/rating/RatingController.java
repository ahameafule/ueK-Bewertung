package ch.noseryoung.uekbewertung.webContext.domain.rating;

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
 * This class holds all REST endpoints targeted towards the entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {

	private RatingService ratingService;
	
	/**
	 * 
	 * @param ratingService
	 */
	@Autowired
	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}
	
	/**
	 * This method returns the requested rating
	 *
	 * @param  id Id of the requested rating
	 * @return    ResponseEntity with the rating that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getById(@PathVariable Long id) {
		Rating rating =  ratingService.findById(id).get();
		return new ResponseEntity<>(rating, HttpStatus.OK);
	}
	
	/**
	 * This method returns all authorities
	 * 
	 * @return
	 */
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Rating>> getAll() {
		List<Rating> authorities = ratingService.findAll();
		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}
	
	/**
	 * This method creates an rating
	 *
	 * @return ResponseEntity with the rating that was created
	 */
	@PostMapping({ "", "/" })
	public ResponseEntity<Rating> create(@Valid @RequestBody Rating rating) {
		ratingService.save(rating);
		return new ResponseEntity<>(rating, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested rating
	 *
	 * @param  id   Id of the rating that should get updated
	 * @param  rating rating entity to which the requested rating should get updated to
	 * @return      ResponseEntity with the updated rating
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateById(@PathVariable Long id, @Valid @RequestBody Rating rating) {
		ratingService.update(rating);
		return new ResponseEntity<>(rating, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested rating
	 *
	 * @param  id Id of the rating that should be deleted
	 * @return    ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		ratingService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
