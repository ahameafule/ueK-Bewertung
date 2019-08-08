/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This interface holds all data access related methods targeted towards
 * the entity course
 * 
 * @author lohse
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	List<Course> findAllByOrderByCourseNumber();
	
	List<Course> findAllByOrderByCourseNumberAsc();
}
