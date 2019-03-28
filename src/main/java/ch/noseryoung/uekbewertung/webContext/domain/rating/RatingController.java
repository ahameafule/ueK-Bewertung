package ch.noseryoung.uekbewertung.webContext.domain.rating;

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

import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;
import ch.noseryoung.uekbewertung.webContext.domain.rating.RatingService;


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
	
	@Autowired
	public RatingController(RatingService service) {
		this.ratingService = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rating> getById(@PathVariable Long id) {
		Optional<Rating> rating = ratingService.findById(id);
		
		HttpStatus status = (rating.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(rating.get(), status);
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Rating>> getAll() {
		List<Rating> authorities = ratingService.findAll();

		return new ResponseEntity<>(authorities, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Rating> create(@Valid @RequestBody Rating rating) {
		ratingService.save(rating);

		return new ResponseEntity<>(rating, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateById(@PathVariable Long id, @Valid @RequestBody Rating rating) {
		ratingService.update(rating, id);

		return new ResponseEntity<>(rating, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		ratingService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
