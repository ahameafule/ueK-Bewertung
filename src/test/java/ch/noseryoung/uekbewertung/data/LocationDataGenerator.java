/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.location.Location;

/**
 * @author lohse
 *
 */
public class LocationDataGenerator implements DataGenerator<Location> {

	@Override
	public DataHolder<Location> generate() {
		
		return DataHolder.of(
				
				new Location("Zuerich", "8001", "Koenigsstrasse", "043 234 12 23"),
				new Location("Weiningen", "8233", "Baumstrasse", "044 222 11 55"),
				new Location("Marlishausen", "8543", "Tuchstrasse", "076 443 32 21")
			);
	}	
}
