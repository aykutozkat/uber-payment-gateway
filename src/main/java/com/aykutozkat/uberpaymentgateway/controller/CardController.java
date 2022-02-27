package com.aykutozkat.uberpaymentgateway.controller;

import com.aykutozkat.uberpaymentgateway.dto.entity.Card;
import com.aykutozkat.uberpaymentgateway.service.CardService;
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
public class CardController {

	@Autowired
	private CardService service;

	@GetMapping(value = "/cards/user/{userToken}")
	public ResponseEntity<List<Card>> getCardsByUserToken(@PathVariable String userToken) {
		try {
			return new ResponseEntity<>(service.getCardsByUserToken(userToken), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}