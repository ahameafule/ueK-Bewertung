/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

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
import ch.noseryoung.uekbewertung.webContext.domain.course.dto.CourseMapper;
import ch.noseryoung.uekbewertung.webContext.domain.location.Location;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

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
public class CourseIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	private DataHolder<Course> dataHolder;
	
	@Before
	public void setup() {
		
		var locations = DataGenerators.forClass(Location.class).generate()
				.asList().stream()
				.peek(a -> a.setId(null))
				.peek(entityManager::persist)
				.collect(Collectors.toCollection(ArrayList::new));
		
		dataHolder = DataGenerators.forClass(Course.class).generate();
		for(int i = 0; i < locations.size(); i++) {
			dataHolder.asList().get(i)
				.setLocation(new Location(locations.get(i).getId(), null, null, null , null));
		}
		
		var users = DataGenerators.forClass(User.class).generate()
			.asList().stream()
			.peek(a -> a.setId(null))
			.peek(entityManager::persist)
			.collect(Collectors.toCollection(ArrayList::new));
		
		dataHolder = DataGenerators.forClass(Course.class).generate();
		for(int i = 0; i < users.size(); i++) {
			dataHolder.asList().get(i)
				.setUser(new User(users.get(i).getId(), null, null, null , null));
		}
		
		dataHolder.asList().stream()
			.peek(u -> u.setId(null))
			.forEach(entityManager::persist);
	}
	
	@Test
	public void test() throws Exception {
		var expectedJson = objectMapper.writeValueAsString(
				courseMapper.toDTOs(dataHolder.asList())
			);
		
		mockMvc.perform(get("/ratings"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(expectedJson));
	}
}
