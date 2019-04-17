/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.question.dto;

import ch.noseryoung.uekbewertung.webContext.domain.rating.dto.RatingDTO;

/**
 * @author lohse
 *
 */
public class QuestionDTO {

	private Long id;
	
	private String text;
	
	private RatingDTO rating;
	
	public QuestionDTO() {}
	
	public QuestionDTO(Long id, String text, RatingDTO rating) {
		
		this.id = id;
		this.text = text;
		this.rating = rating;
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
}
