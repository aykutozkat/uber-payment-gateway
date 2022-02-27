package com.aykutozkat.uberpaymentgateway.controller;

import com.aykutozkat.uberpaymentgateway.dto.response.PingResponse;
import com.aykutozkat.uberpaymentgateway.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PingController {

	@Autowired
	private PingService service;

	@GetMapping(value = "/ping")
	public ResponseEntity<PingResponse> ping() {
		try {
			return new ResponseEntity<>(service.ping(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}