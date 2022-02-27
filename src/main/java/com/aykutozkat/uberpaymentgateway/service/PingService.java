package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.response.PingResponse;
import com.aykutozkat.uberpaymentgateway.util.MarqetaUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class PingService extends BaseService {

	public PingResponse ping() throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaGet(context, "/ping", null)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), PingResponse.class);
			}

			throw new Exception("An error occurred attempting to ping the Marqeta service");
		}
	}

}