package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.UUIDGenerator;

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
	public RatingService(RatingRepository ratingRepository, EntityManager manager) {
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
		List<Rating> currentRating = ratingRepository.findByCourseAndUser(rating.getCourse(), rating.getUser());
	
		if (currentRating.isEmpty()) {
			try {
				rating.setUUID(UUIDGenerator.generateUUID());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			ratingRepository.save(rating);
		} else {
			throw new IllegalArgumentException("This rating already exists");
		}
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
