package ch.noseryoung.uekbewertung.webContext.domain.answer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.noseryoung.uekbewertung.data.DataGenerators;
import ch.noseryoung.uekbewertung.data.DataHolder;
import ch.noseryoung.uekbewertung.webContext.domain.answer.dto.AnswerMapper;

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AnswerController.class, includeFilters = {})
public class AnswerControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AnswerService answerService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AnswerMapper answerMapper;
	
	private DataHolder<Answer> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(Answer.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		
		when(answerService.findAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				answerMapper.toDTOs(dataHolder.asList())
		);
		
        mockMvc.perform(get("/answers"))
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}
