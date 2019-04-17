/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.question.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;

/**
 * @author lohse
 *
 */
@Component
public class QuestionValidation implements Validator {

	public boolean supports(Class<?> clazz) {

		return Question.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "text", "emptytext");
	}
}
