package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

@Entity
@Table(name = "answer")
@IdClass(AnswerId.class)
public class Answer implements Serializable {
	
	@Id @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false, insertable = false, updatable = false)
    private Rating rating;
 
	@Id @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, insertable = false, updatable = false)
    private Question question;
	
	@Column(name = "answer")
	private byte answer;
		
	public Answer() {}
	
	public Answer(Rating rating, Question question) {
		this.rating = rating;
		this.question = question;
	}
	
	public Answer(byte answer) {
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
	public byte getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(byte answer) {
		this.answer = answer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Answer [rating=" + rating + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	
}
