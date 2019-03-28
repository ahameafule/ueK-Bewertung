package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.config.generic.ExtendedEntity;
import ch.noseryoung.uekbewertung.webContext.domain.rating.Rating;


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
	
	@ManyToMany
	@JoinTable(
		name = "rating_question",
		joinColumns = @JoinColumn(name = "question_id"),
		inverseJoinColumns = @JoinColumn(name = "rating_id")
		)
	private Set<Rating> ratings;

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
	 * @return the ratings
	 */
	public Set<Rating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	
}
