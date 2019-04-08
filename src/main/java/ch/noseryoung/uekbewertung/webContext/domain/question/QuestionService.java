package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class implements all data access related methods targeted towards the
 * entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;

	/**
	 * @param questionRepository
	 */
	@Autowired
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	/**
	 * find question by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Question> findById(Long id) {
		Optional<Question> question = questionRepository.findById(id);
		return question;
	}

	/**
	 * find all questions
	 * @return
	 */
	public List<Question> findAll() {
		List<Question> questions = questionRepository.findAll();
		return questions;
	}

	/**
	 * tells the repository where to create a question
	 * @param Question
	 */
	public void save(Question question) {
		questionRepository.save(question);
	}

	/**
	 * updates the givin question defined with id 
	 * @param newQuestion
	 * @param id
	 * @throws NoSuchElementException
	 */
	public void update(Question newQuestion, Long id) throws NoSuchElementException {
		Optional<Question> currentQuestion = questionRepository.findById(id);
		if (currentQuestion.isPresent()) {
			newQuestion.setId(id);
			questionRepository.save(newQuestion);
		} else {
			throw new NoSuchElementException(String.format("No question with given id '%d' found", id));
		}
	}
	
	/**
	 * Tells the repository where to delete the question
	 * @param id
	 */
	public void deleteById(Long id) {
		questionRepository.deleteById(id);
	}
}
