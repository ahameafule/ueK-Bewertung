package ch.noseryoung.uekbewertung.webContext.domain.rating;

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
import ch.noseryoung.uekbewertung.webContext.domain.question.Question;
import ch.noseryoung.uekbewertung.webContext.domain.rating_question.RatingQuestion;

/**
 * This class is the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "rating")
public class Rating extends ExtendedEntity{
		
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
			super(id);
			this.remarks = remarks;
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
