package ch.noseryoung.uekbewertung.webContext.domain.authority;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * This class is the entity authority.
 * 
 * @author Joel Ahameafule
 *
 */
@Entity
@Table(name = "authority")
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
		this.id = id;
		this.name = name;
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
