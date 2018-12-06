package progetto;

import java.io.Serializable;

public class ClientBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String cap;
	String name;
	String surname;
	String city;
	String address;
	String email;
	String region;
	String password;
	String phone;
	int nordini;

	public ClientBean() {

		phone = "";
		name = "";
		surname = "";
		cap = "";
		region = "";
		password = "";
		email = "";
		city = "";
		address = "";
		nordini = 0;
	}

	
	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNordini() {
		return nordini;
	}

	public void setNordini(int nordini) {
		this.nordini = nordini;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "ClientBean [cap=" + cap + ", name=" + name + ", surname=" + surname + ", city=" + city + ", address="
				+ address + ", email=" + email + ", region=" + region + ", password=" + password + ", phone=" + phone
				+ ", nordini=" + nordini + "]";
	}
}