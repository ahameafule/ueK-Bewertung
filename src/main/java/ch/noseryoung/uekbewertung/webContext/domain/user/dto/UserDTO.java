/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user.dto;

import java.util.Date;
import java.util.Set;

import ch.noseryoung.uekbewertung.webContext.domain.role.dto.RoleDTO;

/**
 * @author lohse
 *
 */
public class UserDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date creationdate;
	
	private String email;
	
	private String joinYear;
	
	private Set<RoleDTO> roles;
	
	public UserDTO() {}
	
	public UserDTO(Long id, String firstName, String lastName, Date creationdate, String email, String joinYear, Set<RoleDTO> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationdate = creationdate;
		this.email = email;
		this.joinYear = joinYear;
		this.roles = roles;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the creationdate
	 */
	public Date getCreationdate() {
		return creationdate;
	}

	/**
	 * @param creationdate the creationdate to set
	 */
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the joinYear
	 */
	public String getJoinYear() {
		return joinYear;
	}

	/**
	 * @param joinYear the joinYear to set
	 */
	public void setJoinYear(String joinYear) {
		this.joinYear = joinYear;
	}

	/**
	 * @return the role
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param role the role to set
	 */
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", creationdate="
				+ creationdate + ", email=" + email + ", role=" + roles + "]";
	}
}
