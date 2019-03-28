/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards
 * the entity location
 * 
 * @author lohse
 *
 */
@Service
public class LocationService {
	
	private LocationRepository locationRepository; 
	
	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	/**
	 * find location by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Location> findById(Long id) {
		Optional<Location> location = locationRepository.findById(id);
		return location;
	}
	
	/**
	 * find all locations
	 * @return
	 */

	public List<Location> findAll() {
		List<Location> locations = locationRepository.findAll();
		return locations;
	}
	
	/**
	 * tells mr. repository where to create a location
	 * @param location 
	 */

	public void save(Location location) {
		locationRepository.save(location);
	}
	/**
	 * updates the givin location defined with id 
	 * @param newlocation
	 * @param id
	 * @throws NoSuchElementException
	 */

	public void update(Location newlocation, Long id) throws NoSuchElementException {
		Optional<Location> currentlocation = locationRepository.findById(id);
		if (currentlocation.isPresent()) {
			newlocation.setId(id);
			locationRepository.save(newlocation);
		} else {
			throw new NoSuchElementException(String.format("No location with given id '%d' found", id));
		}
	}
	
	/**
	 * Tells mrs. repository where to delete the location
	 * @param id
	 */

	public void deleteById(Long id) {
		locationRepository.deleteById(id);
	}
}
