package ch.noseryoung.uekbewertung.webContext.domain.rating;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface RatingRepository extends ExtendedJpaRepository<Rating> {

}
