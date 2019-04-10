package ch.noseryoung.uekbewertung.webContext.domain.question;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.answer.Answer;


/**
 * This class is the entity question.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "text")
	private String text;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Answer> ratingQuestions;

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
		this.id = id;
		this.text = text;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ratingQuestions
	 */
	public Set<Answer> getRatingQuestions() {
		return ratingQuestions;
	}

	/**
	 * @param ratingQuestions the ratingQuestions to set
	 */
	public void setRatingQuestions(Set<Answer> ratingQuestions) {
		this.ratingQuestions = ratingQuestions;
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
	public Set<Answer> getQuestions() {
		return ratingQuestions;
	}

	/**
	 * @param questions the roles to set
	 */
	public void setQuestions(Set<Answer> questions) {
		this.ratingQuestions = questions;
	}
	
}
