package com.aykutozkat.uberpaymentgateway.config;

import com.aykutozkat.uberpaymentgateway.dto.Context;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("marqeta")
public class AppConfig {

	private String applicationToken;
	private String adminAccessToken;
	private String baseUrl;
	private String baseUri;

	@Bean
	public Context context() {
		return new Context(applicationToken, adminAccessToken, baseUrl, baseUri);
	}

}