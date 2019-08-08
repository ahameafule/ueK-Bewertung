/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * @author lohse
 *
 */
@Component
public class UserValidation implements Validator {

	public boolean supports(Class<?> clazz) {

		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "creationdate", "empty_creationdate");
		ValidationUtils.rejectIfEmpty(errors, "email", "empty_email");
		ValidationUtils.rejectIfEmpty(errors, "first_name", "empty_first_name");
		ValidationUtils.rejectIfEmpty(errors, "last_name", "empty_last_name");
		
		User user = (User) target;
		if(user.getEmail().contains("@")) {
			
			errors.rejectValue("email", "no_valid_email");
		}
	}
}
