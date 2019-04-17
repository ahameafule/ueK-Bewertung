/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.user.dto;

import java.util.Date;

import ch.noseryoung.uekbewertung.webContext.domain.role.dto.RoleDTO;

/**
 * @author lohse
 *
 */
public class UserDTO {

	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private Date creationdate;
	
	private String email;
	
	private RoleDTO role;
	
	public UserDTO() {}
	
	public UserDTO(Long id, String firstname, String lastname, Date creationdate, String email, RoleDTO role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.creationdate = creationdate;
		this.email = email;
		this.role = role;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @return the role
	 */
	public RoleDTO getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleDTO role) {
		this.role = role;
	}
}
