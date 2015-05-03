package com.richard.mtp.stats;

import java.util.List;

import com.richard.mtp.rest.MarketData;
import com.richard.mtp.store.InMemoryStore;

public class MarketStatisticsCalculator {

	private InMemoryStore inMemoryStore = null;

	public MarketStatisticsCalculator(InMemoryStore inMemoryStore) {
		this.inMemoryStore = inMemoryStore;
	}

	public MarketStatistics getLatestMarketStatistics() {
		MarketStatistics marketStatistics = new MarketStatistics();

		if (inMemoryStore != null) {
			List<MarketData> marketDatas = inMemoryStore.getAll();

			marketStatistics.setNoOfTransactions(marketDatas.size());

			for (MarketData marketData : marketDatas) {
				marketStatistics.add(marketData.getCurrencyFrom(),
						marketData.getAmountSell());
			}
		}
		return marketStatistics;
	}

}
