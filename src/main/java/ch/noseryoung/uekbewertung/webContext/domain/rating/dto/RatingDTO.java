/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.rating.dto;

import ch.noseryoung.uekbewertung.webContext.domain.answer.dto.AnswerDTO;
import ch.noseryoung.uekbewertung.webContext.domain.course.dto.CourseDTO;
import ch.noseryoung.uekbewertung.webContext.domain.user.dto.UserDTO;

/**
 * @author lohse
 *
 */
public class RatingDTO {

	private Long id;
	
	private String remarks;
	
	private String UUID;
	
	private CourseDTO course;
	
	private UserDTO user;
	
	private AnswerDTO answer;
	
	public RatingDTO() {}
	
	public RatingDTO(Long id, String remarks, String UUID, CourseDTO course, UserDTO user, AnswerDTO answer) {
		
		this.id = id;
		this.remarks = remarks;
		this.UUID = UUID;
		this.course = course;
		this.user = user;
		this.answer = answer;
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
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the course
	 */
	public CourseDTO getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(CourseDTO course) {
		this.course = course;
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
	 * @return the answer
	 */
	public AnswerDTO getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(AnswerDTO answer) {
		this.answer = answer;
	}	
}
