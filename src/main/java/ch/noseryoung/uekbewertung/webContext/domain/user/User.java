package ch.noseryoung.uekbewertung.webContext.domain.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
 * @author Joel Ahameafule
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "creationdate")
	private Date creationdate;
	
	@Column(name = "email")
	private String email; 
	
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
	 * @param email
	 * @param creationdate
	 * @param roles
	 */
	public User(
			String firstName, String lastName, Date creationdate, Set<Role> roles
	) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationdate = creationdate; 
		this.roles = roles;
	}

	/**
	 * @Param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param creationdate
	 * @param roles
	 */
	public User(
			Long id, String firstName, String lastName, Date creationdate, Set<Role> roles
	) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationdate = creationdate;
		this.roles = roles;
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
