/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

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
import ch.noseryoung.uekbewertung.webContext.domain.location.Location;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * @author lohse
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private DataHolder<Course> dataHolder;
	
	@Before
	public void setup() {
		
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
		
		dataHolder = DataGenerators.forClass(Course.class).generate();
		
		dataHolder.asList().stream()
			.peek(u -> u.setId(null))
			.forEach(entityManager::persist);
	}
	
	@Test
	public void findAll_returnsAll() {
		assertThat(courseRepository.findAll()).containsExactlyElementsOf(dataHolder.asList());
	}
}
