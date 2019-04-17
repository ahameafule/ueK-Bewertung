/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.location.Location;

/**
 * @author lohse
 *
 */
@Component
public class LocationValidation implements Validator {

	public boolean supports(Class<?> clazz) {

		return Location.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "city", "empty_city");
		ValidationUtils.rejectIfEmpty(errors, "postal", "empty_postal");
		ValidationUtils.rejectIfEmpty(errors, "street", "empty_street");
		ValidationUtils.rejectIfEmpty(errors, "telephone", "empty_telephone");
	}
}
