/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.answer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;
import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;
/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@DataJpaTest
public class AnswerRepositoryTest {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private DataHolder<Answer> dataHolder;
	
	@SuppressWarnings("null")
	@Before
	public void setup() {
		
		var ratings = DataGenerators.forClass(Rating.class).generate()
				.asList().stream()
				.peek(a -> a.setId(null))
				.peek(entityManager::persist)
				.collect(Collectors.toCollection(ArrayList::new));
		
		dataHolder = DataGenerators.forClass(Answer.class).generate();
		for(int i = 0; i < ratings.size(); i++) {
			dataHolder.asList().get(i)
				.setRating(new Rating(ratings.get(i).getId(), null, null));
		}
		
		var questions = DataGenerators.forClass(Question.class).generate()
				.asList().stream()
				.peek(a -> a.setId(null))
				.peek(entityManager::persist)
				.collect(Collectors.toCollection(ArrayList::new));

		dataHolder = DataGenerators.forClass(Answer.class).generate();
		for(int i = 0; i < questions.size(); i++) {
			dataHolder.asList().get(i)
				.setQuestion(new Question(questions.get(i).getId(), null));
		}
		
		dataHolder = DataGenerators.forClass(Answer.class).generate();
		
		dataHolder.asList().stream()
		.peek(u -> u.setAnswer((Byte) null))
		.forEach(entityManager :: persist);
	}
	
	@Test
	public void findAll_returnsAll() {
		assertThat(answerRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
	}
}
