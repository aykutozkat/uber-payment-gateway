package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.entity.ProgramSource;
import com.aykutozkat.uberpaymentgateway.util.MarqetaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProgramFundingService extends BaseService {

	public ProgramSource createProgramSource(String body) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaPost(context, "/fundingsources/program", null, body)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), ProgramSource.class);
			}

			throw new Exception("Could not create program source");
		}
	}

}