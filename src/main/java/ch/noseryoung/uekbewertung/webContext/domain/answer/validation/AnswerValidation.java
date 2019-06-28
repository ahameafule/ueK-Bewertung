/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.answer.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.answer.Answer;

/**
 * @author lohse
 *
 */
@Component
public class AnswerValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return Answer.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "answer", "empty_answer");
	}

}
