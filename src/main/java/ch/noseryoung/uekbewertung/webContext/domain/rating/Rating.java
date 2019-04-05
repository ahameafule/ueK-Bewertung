package ch.noseryoung.uekbewertung.webContext.domain.rating;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.course.Course;
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
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id") 
		private Long id;
		
		@Column(name = "remarks")
		private String remarks;
		
		@ManyToOne()
		@JoinColumn(name = "course_id")
		private Course course;
		
		@ManyToOne()
		@JoinColumn(name = "user_id")
		private User user;
		
		@OneToMany(mappedBy = "rating")
		private Set<RatingQuestion> ratingQuestions;
		
		@ManyToOne
		@JoinColumn(name = "fk_user")
		private User user;
		
		@Column(name = "UUID")
		private String UUID;
		
		public Rating() {}
		
		/**
		 * 
		 * @param remarks
		 * @param user
		 */
		public Rating(String remarks, String UUID) {
			this.remarks = remarks;
			this.user = user;
			this.UUID = UUID;
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
		 * @return the uUID
		 */
		public String getUUID() {
			return UUID;
		}

		/**
		 * @param uUID the uUID to set
		 */
		public void setUUID(String UUID) {
			this.UUID = UUID;
		}

		/**
		 * @return the course
		 */
		public Course getCourse() {
			return course;
		}

		/**
		 * @param course the course to set
		 */
		public void setCourse(Course course) {
			this.course = course;
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
