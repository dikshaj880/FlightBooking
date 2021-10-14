package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entity.Airline;

public interface AirlineService {

	public List<Airline> findAll();
	
	public Airline findById(int theId);
	
	public Airline save(Airline theAirline);
	
	public void deleteById(int theId);
}
