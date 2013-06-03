package org.springframework.samples.mvc.validation;

import javax.validation.constraints.NotNull;

/**
 * Registration.
 *
 * @author Rene Gielen
 */
public class Registration {

	@NotNull(groups = { Name.class })
	private String firstname;
	private String lastname;

	@NotNull(groups = { Address.class })
	private String street;
	private String city;
	private String country;

	@NotNull(groups = { Credentials.class })
	private String username;
	private String password;

	public String getCity() {
		return city;
	}

	public void setCity( String city ) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry( String country ) {
		this.country = country;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname( String firstname ) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname( String lastname ) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet( String street ) {
		this.street = street;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}
}
