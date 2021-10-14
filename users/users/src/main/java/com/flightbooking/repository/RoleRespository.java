package com.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.ERole;
import com.flightbooking.entity.Role;

@Repository
public interface RoleRespository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);
	
}
