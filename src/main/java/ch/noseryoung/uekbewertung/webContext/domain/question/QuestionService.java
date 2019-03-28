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

	public Optional<Question> findById(Long id) {
		Optional<Question> question = questionRepository.findById(id);
		return question;
	}

	public List<Question> findAll() {
		List<Question> authorities = questionRepository.findAll();
		return authorities;
	}

	public void save(Question question) {
		questionRepository.save(question);
	}

	public void update(Question newQuestion, Long id) throws NoSuchElementException {
		Optional<Question> currentQuestion = questionRepository.findById(id);
		if (currentQuestion.isPresent()) {
			newQuestion.setId(id);
			questionRepository.save(newQuestion);
		} else {
			throw new NoSuchElementException(String.format("No question with given id '%d' found", id));
		}
	}

	public void deleteById(Long id) {
		questionRepository.deleteById(id);
	}
}
