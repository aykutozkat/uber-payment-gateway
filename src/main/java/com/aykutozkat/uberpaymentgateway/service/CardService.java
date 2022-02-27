package com.aykutozkat.uberpaymentgateway.service;

import com.aykutozkat.uberpaymentgateway.dto.entity.Card;
import com.aykutozkat.uberpaymentgateway.dto.entity.CardProduct;
import com.aykutozkat.uberpaymentgateway.dto.response.CardResponse;
import com.aykutozkat.uberpaymentgateway.util.MarqetaUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService extends BaseService {

	public List<Card> getCardsByUserToken(String userToken) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaGet(context, "/cards/user/" + userToken, null)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				CardResponse cardResponse = objectMapper.readValue(EntityUtils.toString(httpEntity), CardResponse.class);

				if (cardResponse != null) {
					return cardResponse.getCards();
				}
			}

			return new ArrayList<>();
		}
	}

	public CardProduct createCardProduct(String body) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaPost(context, "/cardproducts", null, body)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), CardProduct.class);
			}

			throw new Exception("Could not create card product");
		}
	}

	public Card createCard(String body) throws Exception {
		try (CloseableHttpResponse closeableHttpResponse = MarqetaUtil.marqetaPost(context, "/cards", null, body)) {
			HttpEntity httpEntity = closeableHttpResponse.getEntity();

			if (httpEntity != null) {
				return objectMapper.readValue(EntityUtils.toString(httpEntity), Card.class);
			}

			throw new Exception("Could not create card");
		}
	}

}