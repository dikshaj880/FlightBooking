package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
