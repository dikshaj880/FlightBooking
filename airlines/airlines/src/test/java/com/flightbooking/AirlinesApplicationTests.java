package com.flightbooking;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightbooking.entity.Airline;
import com.flightbooking.repository.AirlineRepository;
import com.flightbooking.service.AirlineService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AirlinesApplicationTests {

	@Autowired
	private AirlineService service;
	
	@MockBean
	private AirlineRepository repository;
	
	@Test
	public void findAllAirlinesTest() {
		Mockito.
		when(repository.findAll()).thenReturn(Stream
				.of(new Airline("Air Canada","8523658965","Montreal"), new Airline("Air Inida","789652365890","Delhi"))
				.collect(Collectors.toList()));
		

		List<Airline> airlines = service.findAll();

		Assertions.assertSame(2, airlines.size());
		
	}
	
	@Test
	public void addAirlineTest() {
		Airline airline = new Airline("Air England","8523658965","London");
		Mockito.
		when(repository.save(airline)).thenReturn(airline);
		
		//Assertions.assertEquals(airline, service.save(airline));
		
		Assertions.assertEquals(airline,service.save(airline));
		
		
	}

	@Test
	public void deleteAirlineTest() {
		int id=10;
		
		service.deleteById(id);
		Mockito.verify(repository,Mockito.times(1)).deleteById(id);
	}
	
	@Test
	void contextLoads() {
	}

}
