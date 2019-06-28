/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.authority.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * @author lohse
 *
 */
@Component
public class AuthorityValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return Authority.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "name", "empty_name");
	}
}
