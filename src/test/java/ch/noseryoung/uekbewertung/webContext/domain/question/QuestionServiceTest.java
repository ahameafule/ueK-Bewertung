/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.question;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;

/**
 * @author lohse
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

	@InjectMocks
	private QuestionService questionService;
	
	@Mock
	private QuestionRepository questionRepository;
	
	private DataHolder<Question> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Question.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsQuestion() {
		
		Question question = dataHolder.first();
		when(questionRepository.findById(question.getId())).thenReturn(Optional.of(question));
		
		assertThat(questionService.findById(question.getId()))
		.isPresent()
		.contains(question);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsQuestion() {
		
		assertThat(questionService.findById(1312L)).isEmpty();
	}
}
