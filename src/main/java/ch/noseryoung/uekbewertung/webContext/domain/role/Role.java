package ch.noseryoung.uekbewertung.webContext.domain.role;

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

import ch.noseryoung.uekbewertung.webContext.domain.authority.Authority;

/**
 * This class is the entity role.
 * 
 * @author Joel Ahameafule
 */
@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
