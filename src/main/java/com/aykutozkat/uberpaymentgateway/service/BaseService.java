package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService {

	@Autowired
	Context context;

	final ObjectMapper objectMapper = new ObjectMapper();

}