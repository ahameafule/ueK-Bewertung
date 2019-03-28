package ch.noseryoung.uekbewertung.webContext.domain.rating;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class RatingServiceImpl extends ExtendedServiceImpl<Rating, RatingRepository> implements RatingService {

	public RatingServiceImpl(RatingRepository repository) {
		super(repository);
	}
}
