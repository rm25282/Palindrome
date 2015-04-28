package com.richard.mtp.store;

import java.util.ArrayList;
import java.util.List;

import com.richard.mtp.rest.MarketData;

public class InMemoryStore {
    
    private List<MarketData> marketData = new ArrayList<MarketData>();

    public int size() {
        return marketData.size();
    }

    public void add(MarketData marketDataToAdd ) {
        marketData.add(marketDataToAdd);
    }

    public MarketData get(int i) {
        return marketData.get(i);
    }

}
