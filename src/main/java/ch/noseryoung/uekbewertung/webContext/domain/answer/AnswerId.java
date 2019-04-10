package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;

public class AnswerId implements Serializable {
 
    private Long rating;
 
    private Long question;
 
    public AnswerId() {}
 
    public AnswerId(Long ratingId, Long questionId) {
        this.rating = ratingId;
        this.question = questionId;
    }
  
    /**
	 * @return the ratingId
	 */
	public Long getRating() {
		return rating;
	}

	/**
	 * @param ratingId the ratingId to set
	 */
	public void setRating(Long rating) {
		this.rating = rating;
	}

	/**
	 * @return the questionId
	 */
	public Long getQuestion() {
		return question;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestion(Long question) {
		this.question = question;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
 
        AnswerId that = (AnswerId) o;
        return Objects.equals(this.rating, that.rating) &&
               Objects.equals(this.question, that.question);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(rating, question);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnswerId [rating=" + rating + ", question=" + question + "]";
	}
    
    
}