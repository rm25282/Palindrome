package com.richard.mtp.store;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.richard.mtp.rest.MarketData;

public class InMemoryStoreTest {

    private InMemoryStore inMemoryStore = null;
	private MarketData marketData;
    
    @Before 
    public void setup() {
    	inMemoryStore = new InMemoryStore();
    	
    	marketData = new MarketData("user", "GBP", "EUR", 1000, 2000, (long) 0.72, "TODAY", "Ireland");
    }

	@Test
    public void storeInitiallyEmpty() { 
        assertEquals(0, inMemoryStore.size());
    }

    @Test
    public void addEntrySizeIsOne() {    
        inMemoryStore.add(marketData);
        
        assertEquals(1, inMemoryStore.size());
    }
    
    @Test
    public void whatYouAddIsWhatIsRetrieved() {
        inMemoryStore.add(marketData);
        
        assertEquals(marketData, inMemoryStore.get(0));
    }
    
    @Test
    public void addMultipleItemsGetThemAllBack() {
    	MarketData marketData2 = new MarketData("user2", "USD", "YEN", 2000, 2000, (long) 1, Calendar.getInstance().getTime().toString(), "UK");
    	MarketData marketData3 = new MarketData("user3", "RUB", "AUS", 3000, 2000, (long) 0.66, Calendar.getInstance().getTime().toString(), "Spain");
    	MarketData marketData4 = new MarketData("user4", "GBP", "AUS", 4000, 2000, (long) 0.50, Calendar.getInstance().getTime().toString(), "Greece");

    	inMemoryStore.add(marketData);
    	inMemoryStore.add(marketData2);
    	inMemoryStore.add(marketData3);
    	inMemoryStore.add(marketData4);
    	
    	assertEquals(4, inMemoryStore.size());
    	assertEquals(4, inMemoryStore.getAll().size());
    }
}
