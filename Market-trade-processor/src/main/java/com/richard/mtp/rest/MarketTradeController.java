package com.richard.mtp.rest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richard.mtp.stats.MarketStatistics;
import com.richard.mtp.store.InMemoryStore;

@RestController
public class MarketTradeController {

    private InMemoryStore inMemoryStore = new InMemoryStore();
    
    private static MarketStatistics marketStats = new MarketStatistics(); 
    
    @RequestMapping(value = "/mtp", 
            method = RequestMethod.POST)
    public String message(@RequestBody MarketData marketData) {
        inMemoryStore.add(marketData);
        
        marketStats.add(marketData.getCurrencyFrom(), marketData.getAmountBuy());
        
        return "OK";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello");
    }
    
}
