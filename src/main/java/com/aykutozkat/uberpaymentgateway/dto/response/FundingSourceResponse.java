package com.aykutozkat.uberpaymentgateway.dto.response;

import com.aykutozkat.uberpaymentgateway.dto.entity.FundingSource;
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
public class FundingSourceResponse extends BaseResponse {

	@JsonAlias(value = "data")
	private List<FundingSource> fundingSources = new ArrayList<>();

}