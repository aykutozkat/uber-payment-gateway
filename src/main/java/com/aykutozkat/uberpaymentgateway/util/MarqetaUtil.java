package com.aykutozkat.uberpaymentgateway.util;

import com.aykutozkat.uberpaymentgateway.dto.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.MediaType;

import java.util.List;

@Slf4j
public final class MarqetaUtil {

	private MarqetaUtil() {
	}

	public static CloseableHttpResponse marqetaGet(Context context, String contextUrl, List<NameValuePair> nameValuePairs) throws Exception {
		CloseableHttpClient closeableHttpClient = getCloseableHttpClient(context);
		URIBuilder uriBuilder = createUriBuilder(context, contextUrl, nameValuePairs);

		HttpGet httpGet = new HttpGet(uriBuilder.build());
		httpGet.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
		checkResponse(closeableHttpResponse);
		return closeableHttpResponse;
	}

	public static CloseableHttpResponse marqetaPost(Context context, String contextUrl, List<NameValuePair> nameValuePairs, String requestBody) throws Exception {
		CloseableHttpClient closeableHttpClient = getCloseableHttpClient(context);
		URIBuilder uriBuilder = createUriBuilder(context, contextUrl, nameValuePairs);

		HttpPost httpPost = new HttpPost(uriBuilder.build());
		httpPost.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		httpPost.setEntity(new StringEntity(requestBody));

		CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost);
		checkResponse(closeableHttpResponse);
		return closeableHttpResponse;
	}

	private static CloseableHttpClient getCloseableHttpClient(Context context) {
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(context.getApplicationToken(), context.getAdminAccessToken());
		credentialsProvider.setCredentials(AuthScope.ANY, credentials);

		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

		return httpClientBuilder.build();
	}

	private static URIBuilder createUriBuilder(Context context, String contextUrl, List<NameValuePair> nameValuePairs) throws Exception {
		URIBuilder uriBuilder = new URIBuilder(context.getBaseUrl());
		uriBuilder.setPath(context.getBaseUri() + contextUrl);

		if (CollectionUtils.isNotEmpty(nameValuePairs)) {
			uriBuilder.setParameters(nameValuePairs);
		}

		log.debug("uriBuilder.build()={}", uriBuilder.build().toString());
		return uriBuilder;
	}

	private static void checkResponse(HttpResponse httpResponse) throws Exception {
		log.debug("httpResponse.getStatusLine().getStatusCode()={}", httpResponse.getStatusLine().getStatusCode());

		// Simple validation to make sure the response is 2xx.
		if (httpResponse.getStatusLine().getStatusCode() < 200
				|| httpResponse.getStatusLine().getStatusCode() > 299) {
			throw new Exception(httpResponse.getStatusLine().getReasonPhrase());
		}
	}

}