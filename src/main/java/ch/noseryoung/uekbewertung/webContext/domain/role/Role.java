package ch.noseryoung.uekbewertung.webContext.domain.role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.config.generic.ExtendedEntity;
import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * This class is the entity role.
 * 
 * @author Joel Ahameafule
 */
@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(
		name = "authority_role",
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "authority_id")
	)
	private Set<Authority> authorities; 
	
	public Role() {}
	
	/**
	 * 
	 * @param name
	 */
	public Role(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Role(Long id, String name) {
		super(id);
		this.name = name;
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
	 * @return the authorities
	 */
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
