package ch.noseryoung.uekbewertung.webContext.domain.rating_question;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

@Entity
public class RatingQuestion implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn
	private Rating rating;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Question question;
	
	@Column(name = "Answer")
	private String answer;
		
	public RatingQuestion() {}
	
	public RatingQuestion(String answer) {
		this.answer = answer;
	}
	
	public RatingQuestion(Rating rating, Question question, String answer) {
		this.rating = rating;
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
