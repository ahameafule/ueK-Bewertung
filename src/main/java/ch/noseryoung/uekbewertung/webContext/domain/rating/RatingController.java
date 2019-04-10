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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * This class holds all REST endpoints targeted towards the entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@RestController
@RequestMapping("/ratings")
@Api(
		value = "RatingController"
	)
public class RatingController {

private RatingService ratingService;
	
	@Autowired
	public RatingController(RatingService service) {
		this.ratingService = service;
	}

	/**
	 * This method returns the requested Rating
	 * 
	 * @param id Id of the requested Rating
	 * @return ResponseEntity with the Rating that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested rating",
			response = Rating.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested rating",
					required = true
			) }
		)
	@GetMapping("/{id}")
	public ResponseEntity<Rating> getById(@PathVariable Long id) {
		Optional<Rating> rating = ratingService.findById(id);
		
		HttpStatus status = (rating.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(rating.get(), status);
	}

	/**
	 * This method returns all ratings
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint returns all ratings",
			response = Rating.class
		)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Rating>> getAll() {
		List<Rating> ratings = ratingService.findAll();

		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	/**
	 * This method creates a rating
	 * 
	 * @return  ResponseEntity with the rating that was created
	 */
	@ApiOperation(
			value = "This endpoint creates a rating",
			response = Rating.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The rating to be created",
				required = true
			) }
		)
	@PostMapping({ "", "/" })
	public ResponseEntity<Rating> create(@Valid @RequestBody Rating rating) {
		ratingService.save(rating);

		return new ResponseEntity<>(rating, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested rating
	 * 
	 * @param id Id of the rating that should get updated
	 * @param rating Rating entity to which the requested course should get updated to
	 * @return ResponseEntity with the updated rating
	 */
	@ApiOperation(
			value = "This endpoint updates the requested rating",
			response = Rating.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The logged in rating",
				required = true
				) }
		)
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateById(@PathVariable Long id, @Valid @RequestBody Rating rating) {
		ratingService.update(rating, id);

		return new ResponseEntity<>(rating, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested rating
	 * 
	 * @param id Id of the rating that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(
			value = "This endpoint deletes the requested rating",
			response = Rating.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested rating",
					required = true
			) }
		)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		ratingService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
