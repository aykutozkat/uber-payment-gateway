package com.aykutozkat.uberpaymentgateway.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardAcceptorRequest {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;

}