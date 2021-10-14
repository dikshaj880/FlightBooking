package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.entity.Booking;
import com.flightbooking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public void save(Booking theBooking) {
		bookingRepository.save(theBooking);

	}

	@Override
	public void deleteById(int theId) {
		bookingRepository.deleteById(theId);

	}

	@Override
	public Booking findById(int theId) {
		Optional<Booking> result = bookingRepository.findById(theId);

		Booking theBooking = null;
		if (result.isPresent()) {
			theBooking = result.get();
		} else {
			throw new RuntimeException("did not find booking id - " + theId);
		}
		return theBooking;
	}

}
