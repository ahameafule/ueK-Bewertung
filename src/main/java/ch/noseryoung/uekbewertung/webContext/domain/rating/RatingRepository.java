package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.noseryoung.uekbewertung.webContext.domain.course.Course;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This interface holds all data access related methods targeted towards the
 * entity rating.
 * 
 * @author Joel Ahameafule
 *
 */
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	//List<Rating> getByCourseIdAndUserId(@Param("courseId") Long course_id, @Param("userId") Long user_id);
	
	List<Rating> findByCourseAndUser(Course course, User user);
	
	List<Rating> findAllByOrderByCourseCourseNumberAscCourseCourseLeadAsc();
	
	Optional<Rating> findByuuid(String uuid);
	
	Optional<Rating> findByUser(User user);
}
