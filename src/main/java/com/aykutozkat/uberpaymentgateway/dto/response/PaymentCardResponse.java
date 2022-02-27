package com.aykutozkat.uberpaymentgateway.dto.response;

import com.aykutozkat.uberpaymentgateway.dto.entity.PaymentCard;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentCardResponse extends BaseResponse {

	@JsonAlias(value = "data")
	private List<PaymentCard> paymentCards = new ArrayList<>();

}