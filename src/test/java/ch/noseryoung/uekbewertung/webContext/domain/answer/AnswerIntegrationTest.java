package ch.noseryoung.uekbewertung.webContext.domain.answer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;
import ch.noseryoung.uekbewertung.webContext.domain.answer.dto.AnswerMapper;
import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class AnswerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AnswerMapper answerMapper;
	
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
				
				dataHolder.asList().stream()
				.peek(u -> u.setAnswer((Byte) null))
				.forEach(entityManager::persist);
			}
	}
	
	@Test
	public void test() throws Exception {
		var expectedJson = objectMapper.writeValueAsString(
				answerMapper.toDTOs(dataHolder.asList())
			);
		
		mockMvc.perform(get("/ratings"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}
