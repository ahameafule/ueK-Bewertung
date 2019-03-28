/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards
 * the entity location
 * 
 * @author lohse
 *
 */
@Service
public class LocationServiceImpl extends ExtendedServiceImpl<Location, LocationRepository> implements LocationService {
	
	public LocationServiceImpl(LocationRepository repository) {
		super(repository);
	}
}
