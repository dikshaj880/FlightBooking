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

import com.flightbooking.entity.Schedule;
import com.flightbooking.repository.ScheduleRepository;
import com.flightbooking.service.ScheduleService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SchedulesApplicationTests {

	@Autowired
	private ScheduleService service;
	
	@MockBean
	private ScheduleRepository repository;
	
	@Test
	public void findAllSchedulesTest() {
		Mockito.
		when(repository.findAll()).thenReturn(Stream
				.of(new Schedule("Air Canada","delhi","Montreal","120000"), new Schedule("Air Inida","Pune","Delhi","7500"))
				.collect(Collectors.toList()));
		

		List<Schedule> schedules = service.findAll();

		Assertions.assertSame(2, schedules.size());
		
	}
	
	@Test
	void contextLoads() {
	}

}
