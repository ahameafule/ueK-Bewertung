/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;

/**
 * @author lohse
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

	@InjectMocks
	private LocationService locationService;
	
	@Mock
	private LocationRepository locationRepository;
	
	private DataHolder<Location> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Location.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsLocation() {
		
		Location location = dataHolder.first();
		when(locationRepository.findById(location.getId())).thenReturn(Optional.of(location));
		
		assertThat(locationService.findById(location.getId()))
		.isPresent()
		.contains(location);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsLocation() {
		
		assertThat(locationService.findById(1312L)).isEmpty();
	}
}
