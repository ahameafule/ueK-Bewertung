/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

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
 * This class holds all REST endpoints targeted towards the entity role
 * 
 * @author lohse
 *
 */
@RestController
@RequestMapping("/location")
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
	 * This method returns the requested role
	 * 
	 * @param id Id of the requested role
	 * @return ResponseEntity with the location that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Location> getById(@PathVariable Long id) {
		Location location = locationService.findById(id).get();
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
	
	/**
	 * This method returns all locations
	 * 
	 * @return
	 */
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
	@PutMapping("/{id}")
	public ResponseEntity<Location> updatedById(@PathVariable Long id, @Valid @RequestBody Location location) {
		locationService.update(location);
		return new ResponseEntity<>(location, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested location
	 * 
	 * @param id Id of the location that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process of location
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		locationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
