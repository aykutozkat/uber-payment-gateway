package com.aykutozkat.uberpaymentgateway.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funding {

	private BigDecimal amount;
	private FundingSource source;

}