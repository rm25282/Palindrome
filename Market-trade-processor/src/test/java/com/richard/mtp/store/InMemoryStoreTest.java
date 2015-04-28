package com.richard.mtp.store;

import static org.junit.Assert.*;

import org.junit.Test;

import com.richard.mtp.rest.MarketData;

public class InMemoryStoreTest {

    @Test
    public void storeInitiallyEmpty() {
        InMemoryStore inMemoryStore = new InMemoryStore();
                
        assertEquals(0, inMemoryStore.size());
    }

    @Test
    public void addEntrySizeIsOne() {
        InMemoryStore inMemoryStore = new InMemoryStore();
        
        MarketData marketData = new MarketData("user", "GBP", "EUR", 1000, 2000, (long) 0.72, "TODAY", "Ireland");
                
        inMemoryStore.add(marketData);
        
        assertEquals(1, inMemoryStore.size());
    }
    
    @Test
    public void whatYouAddIsWhatIsRetrieved() {
        InMemoryStore inMemoryStore = new InMemoryStore();
        
        MarketData marketData = new MarketData("user", "GBP", "EUR", 1000, 2000, (long) 0.72, "TODAY", "Ireland");
                
        inMemoryStore.add(marketData);
        
        assertEquals(marketData, inMemoryStore.get(0));
    }
}
