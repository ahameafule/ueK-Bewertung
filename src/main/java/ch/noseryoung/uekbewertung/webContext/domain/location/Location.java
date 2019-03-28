/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author lohse
 * This class is the entity location
 *
 */
@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal")
	private String postal;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "telephone")
	private String telephone;

	/**
	 * 
	 */
	public Location() {}

	/**
	 * @param id
	 */
	
	/**
	 * @param city
	 * @param postal
	 * @param street
	 * @param telephone
	 */
	public Location(String city, String postal, String street, String telephone) {
		this.city = city;
		this.postal = postal;
		this.street = street;
		this.telephone = telephone;
	}
	
	public Location(Long id, String city, String postal, String street, String telephone) {
		this.id = id; 
		this.city = city;
		this.postal = postal;
		this.street = street;
		this.telephone = telephone;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postal
	 */
	public String getPostal() {
		return postal;
	}

	/**
	 * @param postal the postal to set
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	
}