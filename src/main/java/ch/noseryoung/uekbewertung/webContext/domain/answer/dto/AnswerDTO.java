/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.answer.dto;

import ch.noseryoung.uekbewertung.webContext.domain.question.dto.QuestionDTO;
import ch.noseryoung.uekbewertung.webContext.domain.rating.dto.RatingDTO;

/**
 * @author lohse
 *
 */
public class AnswerDTO {
	
	private byte answer;
	
	private RatingDTO rating;
	
	private QuestionDTO question;
	
	public AnswerDTO() {}
	
	public AnswerDTO(byte answer, RatingDTO rating, QuestionDTO question) {
		
		this.answer = answer; 
		this.rating = rating;
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public byte getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(byte answer) {
		this.answer = answer;
	}

	/**
	 * @return the rating
	 */
	public RatingDTO getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(RatingDTO rating) {
		this.rating = rating;
	}

	/**
	 * @return the question
	 */
	public QuestionDTO getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
}
