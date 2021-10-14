package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.entity.Schedule;
import com.flightbooking.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	// @Autowired
	// public ScheduleServiceImpl(ScheduleRepository theScheduleRepository) {
	// scheduleRepository= theScheduleRepository;
	// }

	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public List<Schedule> getScheduleBySrcAndDest(String src, String dest) {
		return scheduleRepository.getScheduleBySrcAndDest(src, dest);
	}

	@Override
	public Schedule save(Schedule theSchedule) {
		return scheduleRepository.save(theSchedule);
	}

	@Override
	public void deleteById(int theId) {
		scheduleRepository.deleteById(theId);
	}

	@Override
	public Schedule findById(int theId) {
		Optional<Schedule> result = scheduleRepository.findById(theId);

		Schedule theSchedule = null;
		if (result.isPresent()) {
			theSchedule = result.get();
		} else {
			throw new RuntimeException("did not find schedule id - " + theId);
		}
		return theSchedule;
	}

}
