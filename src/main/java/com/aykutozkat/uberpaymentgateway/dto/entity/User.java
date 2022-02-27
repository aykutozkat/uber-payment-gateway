package com.aykutozkat.uberpaymentgateway.dto.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Base {

	private boolean active;
	private String gender;

	@JsonAlias(value = "first_name")
	private String firstName;

	@JsonAlias(value = "last_name")
	private String lastName;

	private String email;

	@JsonAlias(value = "uses_parent_account")
	private boolean usersParentAccount;

	@JsonAlias(value = "account_holder_group_token")
	private String accountHolderGroupToken;

	private String status;

	@JsonAlias(value = "birth_date")
	private String birthDate;

}