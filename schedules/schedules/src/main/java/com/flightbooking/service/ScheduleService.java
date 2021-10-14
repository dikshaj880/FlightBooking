package com.flightbooking.service;

import java.util.List;


import com.flightbooking.entity.Schedule;

public interface ScheduleService {

	public List<Schedule> findAll();

	public List<Schedule> getScheduleBySrcAndDest(String src, String dest);
	
	public Schedule save(Schedule theSchedule);
	
	public void deleteById(int theId);

	public Schedule findById(int theId);
	
}
