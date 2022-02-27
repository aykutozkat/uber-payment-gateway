package com.aykutozkat.uberpaymentgateway.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Webhook {

	private String endpoint;
	private String username;
	private String password;

}