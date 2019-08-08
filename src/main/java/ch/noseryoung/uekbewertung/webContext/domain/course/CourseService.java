/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This class implements all data access related methods targeted towards
 * the entity course
 * @author lohse
 *
 */
@Service
public class CourseService {
	
	private CourseRepository courseRepository; 
	
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	/**
	 * find course by the giving id
	 * @param id
	 * @return
	 */
	public Optional<Course> findById(Long id) {
		Optional<Course> Course = courseRepository.findById(id);
		return Course;
	}
	
	/**
	 * find all courses
	 * @return
	 */

	public List<Course> findAll() {
		List<Course> courses = courseRepository.findAllByOrderByCourseNumber();
		return courses;
	}
	
	/**
	 * find all courses sorted by asc
	 * @return
	 */
	public List<Course> findAllByOrderByCourseNumber() {
		List<Course> courses = courseRepository.findAllByOrderByCourseNumberAsc();
		return courses;
	}
	/**
	 * tells the repository where to create a course
	 * @param Course 
	 */

	public void save(Course Course) {
		courseRepository.save(Course);
	}
	/**
	 * updates the givin course defined with id 
	 * @param newCourse
	 * @param id
	 * @throws NoSuchElementException
	 */

	public void update(Course newCourse, Long id) throws NoSuchElementException {
		Optional<Course> currentCourse = courseRepository.findById(id);
		if (currentCourse.isPresent()) {
			newCourse.setId(id);
			courseRepository.save(newCourse);
		} else {
			throw new NoSuchElementException(String.format("No Course with given id '%d' found", id));
		}
	}
	
	/**
	 * Tells the repository where to delete the course
	 * @param id
	 */

	public void deleteById(Long id) {
		courseRepository.deleteById(id);
	}
}
