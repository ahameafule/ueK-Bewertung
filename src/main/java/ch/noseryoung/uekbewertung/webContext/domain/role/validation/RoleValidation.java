/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.role.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * @author lohse
 *
 */
@Component
public class RoleValidation implements Validator {

	public boolean supports(Class<?> clazz) {

		return Role.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "trainer", "empty_trainer");
	}
}
