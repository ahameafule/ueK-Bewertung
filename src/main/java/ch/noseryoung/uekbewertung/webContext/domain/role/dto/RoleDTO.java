/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.role.dto;

import ch.noseryoung.uekbewertung.webContext.domain.authority.dto.AuthorityDTO;

/**
 * @author lohse
 *
 */
public class RoleDTO {

	private Long id;
	
	private String name;
	
	private AuthorityDTO authority;
	
	public RoleDTO() {}
	
	public RoleDTO(Long id, String name, AuthorityDTO authority) {
		
		this.id = id;
		this.name = name;
		this.authority = authority;
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
	 * @return the authority
	 */
	public AuthorityDTO getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}
}
