package com.aykutozkat.uberpaymentgateway.controller;

import com.aykutozkat.uberpaymentgateway.dto.entity.Card;
import com.aykutozkat.uberpaymentgateway.dto.entity.CardProduct;
import com.aykutozkat.uberpaymentgateway.dto.entity.ProgramSource;
import com.aykutozkat.uberpaymentgateway.dto.entity.User;
import com.aykutozkat.uberpaymentgateway.service.CardService;
import com.aykutozkat.uberpaymentgateway.service.ProgramFundingService;
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

import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProgramFundingService programFundingService;

	@Autowired
	private CardService cardService;

	@GetMapping(value = "/signupStep1")
	public ResponseEntity<Boolean> signupStep1() {
		try {
			// Step 1: Create user
			String user = new String(Files.readAllBytes(Paths.get("src/main/resources/json/user.json")));
			User createdUser = userService.createUser(user);
			log.debug("User token: " + createdUser.getToken());

			// Step 2: Create program source
			String programSource = new String(Files.readAllBytes(Paths.get("src/main/resources/json/programSource.json")));
			ProgramSource createdProgramSource = programFundingService.createProgramSource(programSource);
			log.debug("JIT token: " + createdProgramSource.getToken());

			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/signupStep2/{userToken}/{jitToken}")
	public ResponseEntity<Boolean> signupStep2(@PathVariable String userToken, @PathVariable String jitToken) {
		try {
			//Step 3: Establishing a Card Product
			String cardProduct = new String(Files.readAllBytes(Paths.get("src/main/resources/json/cardProduct.json")));
			cardProduct = cardProduct.replace("$JIT_TOKEN", jitToken);
			CardProduct createdCardProduct = cardService.createCardProduct(cardProduct);
			log.debug("Card product token: " + createdCardProduct.getToken());

			//Step 4: Creating a new card
			String card = new String(Files.readAllBytes(Paths.get("src/main/resources/json/card.json")));
			card = card.replace("$USER_TOKEN", userToken).replace("$CARD_PRODUCT_TOKEN", createdCardProduct.getToken());
			Card createdCard = cardService.createCard(card);
			log.debug("Card created: " + createdCard.toString());

			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}

}