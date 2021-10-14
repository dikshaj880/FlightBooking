package com.flightbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbooking.entity.Booking;
import com.flightbooking.service.BookingService;

@RestController
@CrossOrigin("http://localhost:4200")
public class BookingController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private BookingService bookingService;

	@GetMapping("/all-flights")
	@CrossOrigin("http://localhost:4200")
	public List<Schedule> findAllFlights() {

		ResponseEntity<List<Schedule>> res = restTemplate.exchange("http://SCHEDULES-SERVICE/schedules", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Schedule>>() {
				});
		return res.getBody();
	}

	@PostMapping("/bookings")
	@CrossOrigin("http://localhost:4200")
	public Booking addAirline(@RequestBody Booking theBooking) {

		theBooking.setId(0);

		bookingService.save(theBooking);

		return theBooking;
	}

	@GetMapping("/bookings")
	@CrossOrigin("http://localhost:4200")
	public List<Booking> getBookings() {
		return bookingService.findAll();
	}

	@DeleteMapping("/bookings/{bookingId}")
	@CrossOrigin("http://localhost:4200")
	public void deleteAirline(@PathVariable int bookingId) {

		Booking tempBooking = bookingService.findById(bookingId);

		if (tempBooking == null) {
			throw new RuntimeException("Booking id not found - " + bookingId);
		}

		bookingService.deleteById(bookingId);

		//return "deleted booking id - " + bookingId;
	}

}
