package com.aykutozkat.uberpaymentgateway.controller;

import com.aykutozkat.uberpaymentgateway.dto.request.TransactionRequest;
import com.aykutozkat.uberpaymentgateway.dto.response.TransactionPostResponse;
import com.aykutozkat.uberpaymentgateway.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AuthorizationController {

	@Autowired
	private AuthorizationService service;

	@PostMapping(value = "/simulate/authorization")
	public ResponseEntity<TransactionPostResponse> postTransaction(@RequestBody TransactionRequest request) {
		try {
			return new ResponseEntity<>(service.postTransaction(request), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}