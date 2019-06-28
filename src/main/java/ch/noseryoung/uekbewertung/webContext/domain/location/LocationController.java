/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds all REST endpoints targeted towards the entity location
 * 
 * @author lohse
 *
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

	private LocationService locationService;
	
	/**
	 * 
	 * @param locationService
	 */
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	/**
	 * This method returns the requested location
	 * 
	 * @param id Id of the requested location
	 * @return ResponseEntity with the location that was requested
	 */
	@ApiOperation(
			value = "This endpoint returns the requested location",
			response = Location.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested location",
					required = true
			) }
		)
	@GetMapping("/{id}")
	public ResponseEntity<Location> getById(@PathVariable Long id) {
		Optional<Location> location = locationService.findById(id);
		
		if(!location.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(location.get(), HttpStatus.OK);
	}
	
	/**
	 * This method returns all locations
	 * 
	 * @return
	 */
	@ApiOperation(
			value = "This endpoint returns all locations",
			response = Location.class
		)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Location>> getAll() {
		List<Location> locations = locationService.findAll();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}
	
	/**
	 * This method creates a location
	 * 
	 * @return ResponseEntity with the location that was created
	 */
	@ApiOperation(
			value = "This endpoint creates a location",
			response = Location.class 
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The location to be created",
				required = true
			) }
		)
	@PostMapping({ "", "/" })
	public ResponseEntity<Location> create(@Valid @RequestBody Location location) {
		locationService.save(location);
		return new ResponseEntity<>(location, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested location
	 * 
	 * @param id Id of the location should get updated
	 * @param location Location entity to which the requested location get updated
	 * @return ResponseEntity with the updated location
	 */
	@ApiOperation(
			value = "This endpoint updates the requested location",
			response = Location.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
				value = "The logged in location",
				required = true
				) }
		)
	@PutMapping("/{id}")
	public ResponseEntity<Location> updatedById(@PathVariable Long id, @Valid @RequestBody Location location) {
		locationService.update(location, id);
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested location
	 * 
	 * @param id Id of the location that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process of location
	 */
	@ApiOperation(
			value = "This endpoint deletes the requested location",
			response = Location.class
		)
		@ApiImplicitParams(
			{ @ApiImplicitParam(
					value = "Id of requested location",
					required = true
			) }
		)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		locationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
