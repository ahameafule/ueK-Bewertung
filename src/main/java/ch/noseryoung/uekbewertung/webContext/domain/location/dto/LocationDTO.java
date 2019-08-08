/**
 * 
 */
package ch.noseryoung.uekbewertung.webContext.domain.location.dto;

/**
 * @author lohse
 *
 */
public class LocationDTO {

	private Long id;
	
	private String city;
	
	private String postal;
	
	private String street;
	
	private String telephone;
	
	public LocationDTO() {}
	
	public LocationDTO(Long id, String city, String postal, String street, String telephone) {
		
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
