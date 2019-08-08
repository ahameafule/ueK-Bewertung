/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.answer;

import org.junit.Before;
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
public class AnswerServiceTest {

	@InjectMocks
	private AnswerService answerService;
	
	@Mock
	private AnswerRepository answerRepository;
	
	@SuppressWarnings("unused")
	private DataHolder<Answer> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Answer.class).generate();	
	}
}
