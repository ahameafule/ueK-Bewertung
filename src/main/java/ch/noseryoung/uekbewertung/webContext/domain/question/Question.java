package ch.noseryoung.uekbewertung.webContext.domain.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	@Column(name = "id")
	private Long id;
	
	@Column(name = "text")
	private String text;

	public Question() {}
	
	public Question(Long id) {
		this.id = id;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + "]";
	}
	
}
