package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * This class implements all data access related methods targeted towards the
 * entity answer.
 * 
 * @author Joel Ahameafule
 *
 */
@Service
public class AnswerService {
	
	private AnswerRepository answerRepository;

	/**
	 * @param answerRepository
	 */
	@Autowired
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	public Optional<Answer> findById(Long id) {
		Optional<Answer> answer = answerRepository.findById(id);
		return answer;
	}
	
	public Optional<Answer> findByRating(Rating rating) {
		Optional<Answer> answer = answerRepository.findByRating(rating);
		return answer;
	}

	public List<Answer> findAll() {
		List<Answer> authorities = answerRepository.findAll();
		return authorities;
	}

	public void save(Answer answer) {
		answerRepository.save(answer);
	}

	public void update(Answer newAnswer) throws NoSuchElementException {
		Optional<Answer> currentAnswer = answerRepository.findByRatingAndQuestion(newAnswer.getRating(), newAnswer.getQuestion());
		if (currentAnswer.isPresent()) {
			answerRepository.save(newAnswer);
		} else {
			throw new NoSuchElementException(String.format("No answer found"));
		}
	}

	public void deleteById(Long id) {
		answerRepository.deleteById(id);
	}
	
	public void delete(Answer answer) {
		answerRepository.delete(answer);
	}
}
