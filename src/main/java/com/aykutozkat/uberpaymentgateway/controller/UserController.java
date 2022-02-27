package com.aykutozkat.uberpaymentgateway.controller;

import com.aykutozkat.uberpaymentgateway.dto.entity.User;
import com.aykutozkat.uberpaymentgateway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/users/{userToken}")
	public ResponseEntity<User> getUser(@PathVariable String userToken) {
		try {
			return new ResponseEntity<>(service.getUserByToken(userToken), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}