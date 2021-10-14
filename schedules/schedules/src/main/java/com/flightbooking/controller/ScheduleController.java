package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.entity.Schedule;
import com.flightbooking.service.ScheduleService;

@RestController
@RequestMapping("/schedules")
@CrossOrigin("http://localhost:4200")

public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
//	@Autowired
//	public ScheduleController(ScheduleService theScheduleService) {
//		scheduleService = theScheduleService;
//	}
	
	@GetMapping("")
	@CrossOrigin("http://localhost:4200")
	public List<Schedule> getSchedules(){
		return scheduleService.findAll();
	}
	
	
	@GetMapping("/srcDest")
	@CrossOrigin("http://localhost:4200")
	public List<Schedule> getSchedules(@RequestParam String src,@RequestParam String dest){
		System.out.println(src + dest);
		return scheduleService.getScheduleBySrcAndDest(src,dest);
		
	}
	
	@PostMapping("")
	public Schedule addSchedule(@RequestBody Schedule theSchedule) {
		
		theSchedule.setId(0);
		
		scheduleService.save(theSchedule);
		
		return theSchedule;
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/{scheduleId}")
	public void deleteSchedule(@PathVariable int scheduleId) {
		
		Schedule tempSchedule = scheduleService.findById(scheduleId);
		
		if(tempSchedule == null) {
			throw new RuntimeException("Airline id not found - " + scheduleId);
		}
		
		scheduleService.deleteById(scheduleId);
		
	}
}
