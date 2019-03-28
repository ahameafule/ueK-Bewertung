/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import org.springframework.stereotype.Service;

import ch.noseryoung.uekbewertung.config.generic.ExtendedServiceImpl;

/**
 * This class implements all data access related methods targeted towards
 * the entity course
 * @author lohse
 *
 */
@Service
public class CourseServiceImpl extends ExtendedServiceImpl<Course, CourseRepository> implements CourseService {
	
	public CourseServiceImpl(CourseRepository repository) {
		super(repository);
	}
}
