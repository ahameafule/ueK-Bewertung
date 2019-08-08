/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

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
public class CourseServiceTest {

	@InjectMocks
	private CourseService courseService;
	
	@Mock
	private CourseRepository courseRepository;
	
	private DataHolder<Course> dataHolder;
	
	@Before
	public void setup()  {
		this.dataHolder = DataGenerators.forClass(Course.class).generate();
	}
	
	@Test
	public void findById_idExists_returnsCourse() {
		
		Course course = dataHolder.first();
		when(courseRepository.findById(course.getId())).thenReturn(Optional.of(course));
		
		assertThat(courseService.findById(course.getId()))
		.isPresent()
		.contains(course);
	}
	
	@Test
	public void findById_idDoesNotExist_returnsCourse() {
		
		assertThat(courseService.findById(1312L)).isEmpty();
	}
}
