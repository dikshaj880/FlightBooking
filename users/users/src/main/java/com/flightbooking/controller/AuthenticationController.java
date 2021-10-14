package com.flightbooking.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.config.JwtUtils;
import com.flightbooking.entity.ERole;
import com.flightbooking.entity.LoginRequest;
import com.flightbooking.entity.Role;
import com.flightbooking.entity.SignupRequest;
import com.flightbooking.entity.User;
import com.flightbooking.repository.RoleRespository;
import com.flightbooking.repository.UserRepository;
import com.flightbooking.service.UserDetailsImpl;
import com.flightbooking.util.JwtResponse;
import com.flightbooking.util.MessageResponse;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRespository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {

		Authentication authentication = null;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		} catch (StackOverflowError e) {
			e.getMessage();
			System.out.println(e.getMessage());
			return null;
		}
		try {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getEmail(), roles));
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	 @PostMapping("/signup")
	    public ResponseEntity<?> registerUser(  @RequestBody SignupRequest signUpRequest) {
	        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	            return ResponseEntity
	                    .badRequest()
	                    .body(new MessageResponse("Error: Username is already taken!"));
	        }

	        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	            return ResponseEntity
	                    .badRequest()
	                    .body(new MessageResponse("Error: Email is already in use!"));
	        }
	        Random r = new Random();
	        Long id= r.nextLong();
	        // Create new user's account
	        User user = new User(signUpRequest.getUsername(),
	                signUpRequest.getEmail(),

	                encoder.encode(signUpRequest.getPassword()));
	        user.setId(id);

	        Set<String> strRoles = signUpRequest.getRole();
	        Set<Role> roles = new HashSet<>();

	        if (strRoles == null) {
	            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	            roles.add(userRole);
	        } else {
	            strRoles.forEach(role -> {
	                switch (role) {
	                    case "admin":
	                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	                        roles.add(adminRole);

	                        break;
	                    default:
	                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	                        roles.add(userRole);
	                }
	            });
	        }

	        user.setRoles(roles);
	        userRepository.save(user);

	        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	    }

}
