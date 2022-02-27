package com.aykutozkat.uberpaymentgateway.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PingResponse {

	private boolean success;
	private String version;
	private String revision;
	private String timestamp;
	private String env;
	private String id;

}