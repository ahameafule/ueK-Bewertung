package ch.noseryoung.uekbewertung.webContext.domain.authority;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.config.generic.ExtendedEntity;
import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * This class is the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(
		name = "authority_role",
		joinColumns = @JoinColumn(name = "authority_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
		)
	private Set<Role> roles;
	
	public Authority() {}
	
	/**
	 * 
	 * @param name
	 */
	public Authority(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Authority(Long id, String name) {
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
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
