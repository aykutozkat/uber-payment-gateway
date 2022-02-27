package com.aykutozkat.uberpaymentgateway.dto.request;

import lombok.Data;

@Data
public abstract class BaseRequest {

	private Webhook webhook;

}