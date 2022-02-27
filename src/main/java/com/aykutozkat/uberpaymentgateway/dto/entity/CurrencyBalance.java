package com.aykutozkat.uberpaymentgateway.dto.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class CurrencyBalance extends BalancesAndAmounts {

	@JsonAlias(value = "currency_code")
	private String currencyCode;

}