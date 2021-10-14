package com.flightbooking.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "airline_name")
	private String airlineName;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "contactAddress")
	private String contactAddress;

	public Airline() {

	}

	public Airline(String airlineName, String contactNumber, String contactAddress) {
		this.airlineName = airlineName;
		this.contactNumber = contactNumber;
		this.contactAddress = contactAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", airlineName=" + airlineName + ", contactNumber=" + contactNumber
				+ ", contactAddress=" + contactAddress + "]";
	}
	

	 @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Airline)) {
	            return false;
	        }
	        Airline airline = (Airline) o;
	        return  Objects.equals(airlineName, airline.airlineName) &&
	                Objects.equals(contactNumber, airline.contactNumber) &&
	                Objects.equals(contactAddress, airline.contactAddress);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(airlineName, contactNumber, contactAddress);
	    }
}
