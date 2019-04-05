package ch.noseryoung.uekbewertung.webContext.domain.answer;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

@Entity
@Table(name = "answer")
public class Answer {

	@EmbeddedId
	private AnswerId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("ratingId")
	private Rating rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("questionId")
	private Question question;
	
	@Column(name = "answer")
	private String answer;
		
	public Answer() {}
	
	public Answer(Rating rating, Question question) {
		this.rating = rating;
		this.question = question;
	}
	
	public Answer(Rating rating, Question question, String answer) {
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
