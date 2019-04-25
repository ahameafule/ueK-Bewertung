/**
 * 
 */
package ch.noseryoung.uekbewertung.data;

import ch.noseryoung.uekbewertung.webContext.domain.answer.Answer;

/**
 * @author lohse
 *
 */
public class AnswerDataGenerator implements DataGenerator<Answer> {

	private RatingDataGenerator ratingGenerator;
	private QuestionDataGenerator questionGenerator;
	
	public AnswerDataGenerator(RatingDataGenerator ratingGenerator, QuestionDataGenerator questionGenerator) {
		this.ratingGenerator = ratingGenerator;
		this.questionGenerator = questionGenerator;
	}
	
	@Override
	public DataHolder<Answer> generate() {
		
		var rating = ratingGenerator.generate();
		var question = questionGenerator.generate();
		
		return DataHolder.of(
				
				new Answer(rating.first(), question.first()),
				new Answer(rating.second(), question.second()),
				new Answer(rating.third(), question.third())
			);
	}
}
