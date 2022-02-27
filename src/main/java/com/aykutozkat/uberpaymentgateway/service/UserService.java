package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.entity.User;
import com.aykutozkat.uberpaymentgateway.dto.response.UserResponse;
import com.aykutozkat.uberpaymentgateway.util.MarqetaUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class UserService extends BaseService {

	public List<User> getAllUsers() throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaGet(context, "/users", null)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				UserResponse userResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), UserResponse.class);

				if (userResponse != null) {
					return userResponse.getUsers();
				}
			}

			return new ArrayList<>();
		}
	}

	public User getUserByToken(String userToken) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaGet(context, "/users/" + userToken, null)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), User.class);
			}

			throw new NoSuchElementException("Could not locate userToken=" + userToken);
		}
	}

	public User createUser(String body) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaPost(context, "/users", null, body)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), User.class);
			}

			throw new Exception("Could not create user");
		}
	}

}