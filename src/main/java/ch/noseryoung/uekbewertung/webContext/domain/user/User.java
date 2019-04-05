package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.noseryoung.uekbewertung.webContext.domain.role.Role;

/**
 * This class is the Entity User. A User can hold multiple roles with its own
 * authorities.
 * 
 * @author Moritz Lauper
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "users_role",
		joinColumns = @JoinColumn(name = "users_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;
	
	public User() {}

	/**

	 * @param firstName
	 * @param lastName
	 * @param roles
	 */
	public User(
			String firstName, String lastName, Set<Role> roles
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}

	/**
	 * @Param id
	 * @param firstName
	 * @param lastName
	 * @param roles
	 */
	public User(
			Long id, String firstName, String lastName, Set<Role> roles
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
