package com.aykutozkat.uberpaymentgateway.dto.response;

import com.aykutozkat.uberpaymentgateway.dto.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionPostResponse {

	private Transaction transaction;

	@JsonProperty(value = "raw_iso8583")
	@JsonAlias(value = "raw_iso8583")
	private Object rawIso8583;

}