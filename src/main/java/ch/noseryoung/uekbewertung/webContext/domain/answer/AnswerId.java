package ch.noseryoung.uekbewertung.webContext.domain.answer;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnswerId implements Serializable {
 
    @Column(name = "rating_id")
    private Long ratingId;
 
    @Column(name = "question_id")
    private Long questionId;
 
    private AnswerId() {}
 
    public AnswerId(
        Long ratingId,
        Long questionId) {
        this.ratingId = ratingId;
        this.questionId = questionId;
    }
  
    /**
	 * @return the ratingId
	 */
	public Long getRatingId() {
		return ratingId;
	}

	/**
	 * @param ratingId the ratingId to set
	 */
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
 
        AnswerId that = (AnswerId) o;
        return Objects.equals(this.ratingId, that.ratingId) &&
               Objects.equals(this.questionId, that.questionId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(ratingId, questionId);
    }
}