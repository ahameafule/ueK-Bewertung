package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * This interface holds all data access related methods targeted towards the
 * entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
