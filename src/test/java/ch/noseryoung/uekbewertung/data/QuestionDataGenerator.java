/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;

/**
 * @author lohse
 *
 */
public class QuestionDataGenerator implements DataGenerator<Question> {

	@Override
	public DataHolder<Question> generate() {
		
		return DataHolder.of(
				
				new Question("Question one?"),
				new Question("Question two?"),
				new Question("Question three?")
			);
	}
}
