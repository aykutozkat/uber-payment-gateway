package com.aykutozkat.uberpaymentgateway.dto.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class Card extends Base {

	@JsonAlias(value = "user_token")
	private String userToken;

	@JsonAlias(value = "card_product_token")
	private String cardProductToken;

	@JsonAlias(value = "last_four")
	private String lastFour;

	private String pan;
	private String expiration;

	@JsonAlias(value = "expiration_time")
	private Timestamp expirationTime;

	private String barcode;

	@JsonAlias(value = "pin_is_set")
	private boolean pinSet;

	private String state;

	@JsonAlias(value = "state_reason")
	private String stateReason;

	@JsonAlias(value = "fulfillment_status")
	private String fulfillmentStatus;

	@JsonAlias(value = "instrument_type")
	private String instrumentType;

	private boolean expedite;

}