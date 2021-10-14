package com.flightbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="airline_name")
	private String AirlineName;
	
	@Column(name="source")
	private String Source;
	
	@Column(name="destination")
	private String Destination;
	
	@Column(name="price")
	private String Price;
	
	public Schedule() {
		
	}

	public Schedule(String airlineName, String source, String destination , String price ) {
		AirlineName = airlineName;
		Source = source;
		Destination = destination;
		Price = price;
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAirlineName() {
		return AirlineName;
	}

	public void setAirlineName(String airlineName) {
		AirlineName = airlineName;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Schedule [Id=" + Id + ", AirlineName=" + AirlineName + ", Source=" + Source + ", Destination="
				+ Destination + ", Price=" + Price + "]";
	}

	

	
	
	
	
	
	
	
}
