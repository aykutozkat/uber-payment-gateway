package com.aykutozkat.uberpaymentgateway.dto.response;

import com.aykutozkat.uberpaymentgateway.dto.entity.User;
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
public class UserResponse extends BaseResponse {

	@JsonAlias(value = "data")
	private List<User> users = new ArrayList<>();

}