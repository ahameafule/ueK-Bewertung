package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class RatingService {

	private RatingRepository ratingRepository;

	/**
	 * @param ratingRepository
	 */
	@Autowired
	public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	public Optional<Rating> findById(Long id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		return rating;
	}

	public List<Rating> findAll() {
		List<Rating> authorities = ratingRepository.findAll();
		return authorities;
	}

	public void save(Rating rating) {
		ratingRepository.save(rating);
	}

	public void update(Rating newRating, Long id) throws NoSuchElementException {
		Optional<Rating> currentRating = ratingRepository.findById(id);
		if (currentRating.isPresent()) {
			newRating.setId(id);
			ratingRepository.save(newRating);
		} else {
			throw new NoSuchElementException(String.format("No rating with given id '%d' found", id));
		}
	}

	public void deleteById(Long id) {
		ratingRepository.deleteById(id);
	}
}
