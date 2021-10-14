package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entity.Booking;

public interface BookingService {

	public List<Booking> findAll();
	
	public Booking findById(int theId);
	
	public void save(Booking theBooking);
	
	public void deleteById(int theId);
}
