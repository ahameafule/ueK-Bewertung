/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.location.Location;
import ch.noseryoung.uekbewertung.webContext.domain.user.User;

/**
 * This class is the entity course
 * 
 * @author lohse
 *
 */
@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "course_number")
	private String courseNumber;
		
	@ManyToOne
	@JoinColumn(name = "fk_location")
	private Location location; 
		
	@ManyToOne
	@JoinColumn(name = "fk_user")
	private User user;

	/**
	 * 
	 */
	public Course() {}

	/**
	 * @param courseNumber
	 * @param location
	 * @param user
	 */
	public Course(String courseNumber, Location location, User user) {
		this.courseNumber = courseNumber;
		this.location = location;
		this.user = user;
	}
	
	/**
	 * @param id
	 * @param courseNumber
	 * @param location
	 * @param user
	 */
	public Course(Long id, String courseNumber, Location location, User user) {
		this.id = id; 
		this.courseNumber = courseNumber;
		this.location = location;
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
	 * @return the courseNumber
	 */
	public String getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @param courseNumber the courseNumber to set
	 */
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
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
}




	