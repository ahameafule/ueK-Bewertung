package ch.noseryoung.uekbewertung.webContext.domain.question;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards the
 * entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class QuestionServiceImpl extends ExtendedServiceImpl<Question, QuestionRepository> implements QuestionService {

	public QuestionServiceImpl(QuestionRepository repository) {
		super(repository);
	}
}
