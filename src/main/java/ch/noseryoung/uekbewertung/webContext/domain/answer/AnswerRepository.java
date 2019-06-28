package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	Optional<Answer> findByRatingAndQuestion(Rating rating, Question question);
	
	List<Answer> findByRating(Rating rating);
	
	List<Answer> findAnswerByRating_uuid(String uuid);
	
}
