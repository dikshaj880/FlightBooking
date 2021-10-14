package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query(value= "select * from schedule where source =:src and destination =:dest", nativeQuery = true)
	public List<Schedule> getScheduleBySrcAndDest(@Param("src") String src, @Param("dest") String dest);
}
