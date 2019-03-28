package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.config.generic.ExtendedEntity;
import ch.noseryoung.uekbewertung.webContext.domain.question.Question;

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
		
		@ManyToMany
		@JoinTable(
			name = "rating_question",
			joinColumns = @JoinColumn(name = "rating_id"),
			inverseJoinColumns = @JoinColumn(name = "question_id")
			)
		private Set<Question> questions;
		
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
		public Set<Question> getQuestions() {
			return questions;
		}

		/**
		 * @param questions the roles to set
		 */
		public void setQuestions(Set<Question> questions) {
			this.questions = questions;
		}
}
