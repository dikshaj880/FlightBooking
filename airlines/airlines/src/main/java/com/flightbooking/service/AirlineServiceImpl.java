package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.entity.Airline;
import com.flightbooking.repository.AirlineRepository;

@Service
public class AirlineServiceImpl implements AirlineService {

	private AirlineRepository airlineRepository;
	
	@Autowired
	public AirlineServiceImpl(AirlineRepository theAirlineRepository) {
		airlineRepository = theAirlineRepository;
	}
	@Override
	public List<Airline> findAll() {
		return airlineRepository.findAll();
	}

	@Override
	public Airline findById(int theId) {
		Optional<Airline> result = airlineRepository.findById(theId);
		
		Airline theAirline = null;
		if(result.isPresent()) {
			theAirline=result.get();
		}
		else {
			throw new RuntimeException("did not find airline id - " + theId);
		}
		return theAirline;
	}

	@Override
	public Airline save(Airline theAirline) {
		return airlineRepository.save(theAirline);
		
	}

	@Override
	public void deleteById(int theId) {
		airlineRepository.deleteById(theId);
		
	}

}
