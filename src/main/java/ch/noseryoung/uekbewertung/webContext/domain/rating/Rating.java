package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.rating_question.RatingQuestion;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

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
		
		@ManyToOne
		@JoinColumn(name = "fk_user")
		private User user;
		
		public Rating() {}
		
		/**
		 * 
		 * @param remarks
		 * @param user
		 */
		public Rating(String remarks, User user) {
			this.remarks = remarks;
			this.user = user;
		}
		
		/**
		 * 
		 * @param id
		 * @param remarks
		 * @param user
		 */
		public Rating(Long id, String remarks, User user) {
			this.id = id;
			this.remarks = remarks;
			this.user = user;
		}

		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
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
