/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.rating.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

/**
 * @author lohse
 *
 */
@Component
public class RatingValidation implements Validator {

	public boolean supports(Class<?> clazz) {

		return Rating.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "uuid", "empty_uuid");
		ValidationUtils.rejectIfEmpty(errors, "remarks", "empty_remarks");
	}	
}
