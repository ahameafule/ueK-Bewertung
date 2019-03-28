package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.config.generic.ExtendedEntity;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;
import ch.noseryoung.uekbewertung.webContext.domain.rating_question.RatingQuestion;


/**
 * This class is the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "question")
public class Question extends ExtendedEntity {
	
	@Column(name = "text")
	private String text;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<RatingQuestion> ratingQuestions;

	public Question() {}
	
	/**
	 * 
	 * @param text
	 */
	public Question(String text) {
		this.text = text;
	}
	
	/**
	 * 
	 * @param id
	 * @param text
	 */
	public Question(Long id, String text) {
		super(id);
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the questions
	 */
	public Set<RatingQuestion> getQuestions() {
		return ratingQuestions;
	}

	/**
	 * @param questions the roles to set
	 */
	public void setQuestions(Set<RatingQuestion> questions) {
		this.ratingQuestions = questions;
	}
	
}
