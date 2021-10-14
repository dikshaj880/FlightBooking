package com.flightbooking;

public class Schedule {

	private int Id;
	private String AirlineName;
	private String Source;
	private String Destination;
	private String Price;

	public Schedule() {

	}

	public Schedule(String airlineName, String source, String destination,String price) {
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
