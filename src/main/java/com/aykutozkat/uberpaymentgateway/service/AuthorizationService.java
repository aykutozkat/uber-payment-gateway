package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.request.TransactionRequest;
import com.aykutozkat.uberpaymentgateway.dto.response.TransactionPostResponse;
import com.aykutozkat.uberpaymentgateway.util.MarqetaUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService extends BaseService {

	public TransactionPostResponse postTransaction(TransactionRequest request) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaPost(context, "/simulate/authorization", null, objectMapper.writeValueAsString(request))) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), TransactionPostResponse.class);
			}

			return null;
		}
	}

}