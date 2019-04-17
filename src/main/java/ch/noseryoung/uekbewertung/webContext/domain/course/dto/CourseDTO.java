/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.course.dto;

import ch.noseryoung.uekbewertung.webContext.domain.location.dto.LocationDTO;
import ch.noseryoung.uekbewertung.webContext.domain.user.dto.UserDTO;

/**
 * @author lohse
 *
 */
public class CourseDTO {

	private Long id;
	
	private String courseNumber;
	
	private LocationDTO location;
	
	private UserDTO user;
	
	public CourseDTO() {}
	
	public CourseDTO(Long id, String courseNumber, LocationDTO location, UserDTO user) {
		
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
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the course number
	 */
	public String getCourseNumber() {
		return courseNumber;
	}
	/**
	 * @param courseNumber
	 */
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}

	/**
	 * @return the location
	 */
	public LocationDTO getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
}
