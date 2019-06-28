/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.role;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import ch.noseryoung.uekbewertung.data.DataHolder;
import ch.noseryoung.uekbewertung.webContext.domain.role.dto.RoleMapper;

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
public class RoleIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	private DataHolder<Role> dataHolder;
	
	@Before
	public void setup() {
		
		dataHolder.asList().stream()
			.peek(u -> u.setId(null))
			.forEach(entityManager::persist);
	}
	
	@Test
	public void test() throws Exception {
		var expectedJson = objectMapper.writeValueAsString(
				roleMapper.toDTOs(dataHolder.asList())
			);
		
		mockMvc.perform(get("/roles"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}

