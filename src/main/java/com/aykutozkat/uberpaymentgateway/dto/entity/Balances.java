package com.aykutozkat.uberpaymentgateway.dto.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Balances {

	@JsonProperty(value = "USD")
	@JsonAlias(value = "USD")
	private CurrencyBalance usd;

}