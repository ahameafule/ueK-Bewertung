/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.course.Course;

/**
 * @author lohse
 *
 */
@Component
public class CourseValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "course_number", "empty_course_number");
	}
}
