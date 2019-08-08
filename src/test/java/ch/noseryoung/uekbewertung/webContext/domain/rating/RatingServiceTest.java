/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.rating;

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
public class RatingServiceTest {

	@InjectMocks
	private RatingService ratingService;
	
	@Mock
	private RatingRepository ratingRepository;
	
	private DataHolder<Rating> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Rating.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsRating() {
		
		Rating rating = dataHolder.first();
		when(ratingRepository.findById(rating.getId())).thenReturn(Optional.of(rating));
		
		assertThat(ratingService.findById(rating.getId()))
		.isPresent()
		.contains(rating);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsRating() {
		
       assertThat(ratingService.findById(1312L)).isEmpty();
	}
}
