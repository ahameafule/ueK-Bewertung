/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.question;

import static org.assertj.core.api.Assertions.assertThat;

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

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@DataJpaTest
public class QuestionRepositoryTest {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private DataHolder<Question> dataHolder;
	
	@Before
	public void setup() {
		
		dataHolder = DataGenerators.forClass(Question.class).generate();
		
		dataHolder.asList().stream()
		.peek(u -> u.setId(null))
		.forEach(entityManager :: persist);
	}
	
	@Test
	public void findAll_returnsAll() {
		assertThat(questionRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
	}
}
