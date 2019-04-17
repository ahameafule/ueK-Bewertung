/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uekbewertung.webContext.domain.course.Course;

/**
 * @author lohse
 *
 */
@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CourseMapper {

	Course fromDTO(CourseDTO courseDto);
	
	CourseDTO toDTO(Course course);
	
	List<Course> fromDTOs(List<CourseDTO> courseDtos);
	
	List<CourseDTO> toDTOs(List<Course> courses);
}
