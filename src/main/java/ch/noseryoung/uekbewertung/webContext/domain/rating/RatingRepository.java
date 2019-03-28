package ch.noseryoung.uekbewertung.webContext.domain.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
