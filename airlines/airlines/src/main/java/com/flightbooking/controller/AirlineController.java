package com.flightbooking.controller;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.entity.Airline;
import com.flightbooking.service.AirlineService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1.0/flight")
@CrossOrigin("http://localhost:4200")
public class AirlineController {

	private AirlineService airlineService;
	
	@Autowired
	public AirlineController(AirlineService theAirlineService) {
		airlineService = theAirlineService;
	}
	
	@GetMapping("/airlines")
	@ApiOperation(
	        value = "Find all airlines",
	        notes = "Header is not required",
	        response = List.class
	    )
	public List<Airline> findAll(){
		return airlineService.findAll();
	}
	
	@GetMapping("/airlines/{airlineId}")
	@ApiOperation(
	        value = "Find airline by id",
	        notes = "Id is required",
	        response = Airline.class
	    )
	//@Cacheable(key="#airlineId",value = "Airline")
	public Airline getAirline(@PathVariable int airlineId){
		
		Airline theAirline = airlineService.findById(airlineId);
		
		if(theAirline == null) {
			throw new RuntimeException("Airline id not found - " + airlineId);
		}
		
		return theAirline;
	}
	
	@PostMapping("/airlines")
	public Airline addAirline(@RequestBody Airline theAirline) {
		
		theAirline.setId(0);
		
		airlineService.save(theAirline);
		
		return theAirline;
	}
	
	@PutMapping("/airlines")
	public Airline updateAirline(@RequestBody Airline theAirline) {
		airlineService.save(theAirline);
		
		return theAirline;
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/airlines/{airlineId}")
	public void deleteAirline(@PathVariable int airlineId) {
		
		Airline tempAirline = airlineService.findById(airlineId);
		
		if(tempAirline == null) {
			throw new RuntimeException("Airline id not found - " + airlineId);
		}
		
		airlineService.deleteById(airlineId);
		
		//return "deleted airline id - " + airlineId;
	}
}
