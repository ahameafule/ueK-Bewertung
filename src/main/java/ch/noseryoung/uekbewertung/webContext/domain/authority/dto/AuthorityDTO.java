/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.authority.dto;

import ch.noseryoung.uekbewertung.webContext.domain.role.dto.RoleDTO;

/**
 * @author lohse
 *
 */
public class AuthorityDTO {

	private Long id;
	
	private String name;
	
	private RoleDTO role;
	
	public AuthorityDTO() {}
	
	public AuthorityDTO(Long id, String name, RoleDTO role) {
		this.id = id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
