package com.richard.mtp.stats;

import java.util.Hashtable;
import java.util.Map;

public class MarketStatistics {
    
    private Map<String, Long> currencySold = new Hashtable<String, Long>();
    
    public MarketStatistics() {
        currencySold.put("EUR", (long) 0);
        currencySold.put("USD", (long) 0);
        currencySold.put("GBP", (long) 0);
        currencySold.put("YEN", (long) 0);
        currencySold.put("AUS", (long) 0);
        currencySold.put("OTHER", (long) 0);
    }

    public void add(String currency, long amount) {
       if (currencySold.containsKey(currency)) {
           long currentAmount = currencySold.get(currency);
           currencySold.put(currency, currentAmount+amount);    
       } else {
           long currentAmount = currencySold.get("OTHER");
           currencySold.put(currency, currentAmount+amount);
       }
    }

    public long getAmountForCurrency(String currency) {
        return currencySold.get(currency);
    }

}
