package com.richard.mtp.stats;

import static org.junit.Assert.*;

import org.junit.Test;

import com.richard.mtp.rest.MarketData;
import com.richard.mtp.rest.MarketDataToDisplay;
import com.richard.mtp.store.InMemoryStore;

public class MarketStatisticsCalculatorTest {
    
	@Test
	public void checkStatisticsDataAfterNoTransactions() {
		InMemoryStore inMemoryStore = new InMemoryStore();
		
		MarketStatisticsCalculator marketStatisticsCalculator = new MarketStatisticsCalculator(inMemoryStore);
		
		assertEquals(0, marketStatisticsCalculator.getLatestMarketStatistics().getNoOfTransactions());
	}
	
    @Test
    public void checkStatisticsDataAfterOneTransaction() {
    	
    	InMemoryStore inMemoryStore = setUpMarketDataInMemoryStore();
    	
    	MarketStatisticsCalculator marketStatistics = new MarketStatisticsCalculator(inMemoryStore);
    	
    	assertEquals(1000, marketStatistics.getLatestMarketStatistics().getAmountForCurrency("GBP"));
    	assertEquals(1, marketStatistics.getLatestMarketStatistics().getNoOfTransactions());
    }

	private InMemoryStore setUpMarketDataInMemoryStore() {
		InMemoryStore inMemoryStore = new InMemoryStore();
		
		MarketData marketData = new MarketData("user", "GBP", "EUR", 1000, 2000, (long) 0.72, "TODAY", "Ireland");
		
		inMemoryStore.add(marketData);
		
		return inMemoryStore;
	}
}
