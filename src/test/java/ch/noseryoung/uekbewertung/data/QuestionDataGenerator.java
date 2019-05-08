/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;

/**
 * This class puts data in the entity Question
 * @author lohse
 *
 */
public class QuestionDataGenerator implements DataGenerator<Question> {

/*
 * Generates testdata in the entity Question
 */
	@Override
	public DataHolder<Question> generate() {
		
		return DataHolder.of(
				
				new Question("Question one?"),
				new Question("Question two?"),
				new Question("Question three?")
			);
	}
}
