package com.aykutozkat.uberpaymentgateway.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class CardProduct extends Base {

}