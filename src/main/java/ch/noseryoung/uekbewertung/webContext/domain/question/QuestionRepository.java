package ch.noseryoung.uekbewertung.webContext.domain.question;

import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface QuestionRepository extends ExtendedJpaRepository<Question> {

}
