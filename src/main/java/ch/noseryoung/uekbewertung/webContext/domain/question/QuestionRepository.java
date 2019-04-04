package ch.noseryoung.uekbewertung.webContext.domain.question;

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
public interface QuestionRepository extends JpaRepository<Question, Long> {

}