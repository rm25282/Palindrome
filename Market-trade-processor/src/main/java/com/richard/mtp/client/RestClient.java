package com.richard.mtp.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.richard.mtp.rest.MarketData;

public class RestClient {

	private static RestTemplate restTemplate;
	private static MarketData marketData;
	private static List<String> currencies;

	public static void main(String[] args) {

		dataSetup();

		for (int i = 1; i < 10; i++) {
			for (String currency : currencies) {

				marketData.setCurrencyFrom(currency);
				marketData.setAmountSell(i * new Random().nextInt(1000000));
				
				HttpHeaders headers = new HttpHeaders();
				headers.set("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<MarketData> entity = new HttpEntity<MarketData>(marketData, headers);
				
				ResponseEntity<String> response = restTemplate.postForEntity(
				 "http://192.168.1.217:8080/mtp", entity, String.class);

				System.out.println(response);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void dataSetup() {
		restTemplate = new RestTemplate();

		marketData = new MarketData("123456", "USD", "YEN", 9876543, 12834,
				(long) 0.57, "02/04/15", "FRA");

		currencies = new ArrayList<String>();
		currencies.add("EUR");
		currencies.add("USD");
		currencies.add("GBP");
		currencies.add("YEN");
		currencies.add("AUS");
		currencies.add("RUB");
		currencies.add("INR");
	}

}
