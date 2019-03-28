package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.rating_question.RatingQuestion;

/**
 * This class is the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "rating")
public class Rating {
	
		@Id
		@GeneratedValue
		private Long id;
		
		@Column(name = "remarks")
		private String remarks;
		
		@OneToMany(mappedBy = "rating", cascade = CascadeType.ALL)
		private Set<RatingQuestion> ratingQuestions;
		
		public Rating() {}
		
		/**
		 * 
		 * @param remarks
		 */
		public Rating(String remarks) {
			this.remarks = remarks;
		}
		
		/**
		 * 
		 * @param id
		 * @param remarks
		 */
		public Rating(Long id, String remarks) {
			this.id = id;
			this.remarks = remarks;
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
		public Set<RatingQuestion> getRatingQuestions() {
			return ratingQuestions;
		}

		/**
		 * @param ratingQuestions the ratingQuestions to set
		 */
		public void setRatingQuestions(Set<RatingQuestion> ratingQuestions) {
			this.ratingQuestions = ratingQuestions;
		}

		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}

		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
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
