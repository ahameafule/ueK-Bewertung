/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface holds all data access related methods targeted towards
 * the entity course
 * 
 * @author lohse
 *
 */
public interface CourseRepository extends JpaRepository<Course, Long>{

}
