package com.richard.mtp.rest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richard.mtp.stats.MarketStatistics;
import com.richard.mtp.stats.MarketStatisticsCalculator;
import com.richard.mtp.store.InMemoryStore;
import com.richard.mtp.web.MarketDataToDisplay;

@RestController
public class MarketTradeController {

	private InMemoryStore inMemoryStore = new InMemoryStore();

	private MarketStatisticsCalculator marketStatisticsCalculator = new MarketStatisticsCalculator(
			inMemoryStore);

	@RequestMapping(value = "/mtp", method = RequestMethod.POST)
	public String message(@RequestBody MarketData marketData) {

		inMemoryStore.add(marketData);

		return "OK";
	}

	@MessageMapping("/getstats")
	@SendTo("/topic/stats")
	public MarketDataToDisplay getLatestMarketStats() throws Exception {
		return convertStatsToDisplayMessage();
	}

	private MarketDataToDisplay convertStatsToDisplayMessage() {
		MarketStatistics marketStatistics = marketStatisticsCalculator
				.getLatestMarketStatistics();

		MarketDataToDisplay marketDataToDisplay = new MarketDataToDisplay(
				String.valueOf(marketStatistics.getAmountForCurrency("EUR")),
				String.valueOf(marketStatistics.getAmountForCurrency("USD")),
				String.valueOf(marketStatistics.getAmountForCurrency("GBP")),
				String.valueOf(marketStatistics.getAmountForCurrency("YEN")),
				String.valueOf(marketStatistics.getAmountForCurrency("AUS")),
				String.valueOf(marketStatistics.getAmountForCurrency("OTHER")),
				String.valueOf(marketStatistics.getNoOfTransactions()));
		
		return marketDataToDisplay;
	}
}
