/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user;

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
import ch.noseryoung.uekbewertung.webContext.domain.user.dto.UserMapper;

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class, includeFilters = {})
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	private DataHolder<User> dataHolder;
	
	@Before
	public void setup() {
		this.dataHolder = DataGenerators.forClass(User.class).generate();
	}
	
	@Test
	public void test() throws Exception {
		
		when(userService.findAll()).thenReturn(dataHolder.asList());
		
		var expectedJson = objectMapper.writeValueAsString(
				userMapper.toDTOs(dataHolder.asList())
		);
		
        mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}
