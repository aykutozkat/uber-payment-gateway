package com.aykutozkat.uberpaymentgateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Context {

	private String applicationToken;
	private String adminAccessToken;
	private String baseUrl;
	private String baseUri;

}