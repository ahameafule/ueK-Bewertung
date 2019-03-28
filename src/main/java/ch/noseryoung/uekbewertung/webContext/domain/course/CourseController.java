/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class holds all REST endpoints targeted towards the entity course
 * 
 * @author lohse
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;
	
	/**
	 * @param roleService
	 */
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService; 
	}
	
	/**
	 * This method returns the requested course
	 * 
	 * @param id Id of the requested course
	 * @return ResponseEntity with the course that was requested
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Course> getById(@PathVariable Long id) {
		Optional<Course> course = courseService.findById(id);
		
		if(!course.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(course.get(), HttpStatus.OK);
	}
	
	/**
	 * This method returns all courses
	 * 
	 * @return
	 */
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Course>> getAll() {
		List<Course> courses = courseService.findAll();
		
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	/**
	 * This method creates a course
	 * 
	 * @return  ResponseEntity with the course that was created
	 */
	@PostMapping({ "", "/"})
	public ResponseEntity<Course> create(@Valid @RequestBody Course course) {
		courseService.save(course);
		
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}
	
	/**
	 * This method updates the requested course
	 * 
	 * @param id Id of the course that should get updated
	 * @param course Course entity to which the requested course should get updated to
	 * @return ResponseEntity with the updated course
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Course> updatedById(@PathVariable Long id, @Valid @RequestBody Course course) {
		courseService.update(course, id);
		
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	/**
	 * This method deletes the requested course
	 * 
	 * @param id Id of the course that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		courseService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
