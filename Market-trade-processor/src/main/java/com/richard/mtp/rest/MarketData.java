package com.richard.mtp.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketData {

    private String user = null;
    private String currencyFrom = null;
    private String currencyTo = null;
    private long amountSell = -1;
    private long amountBuy = -1;
    private long rate = -1;
    private String timePlaced = null;
    private String originatingCountry = null;

    public MarketData(@JsonProperty("user") String user,
            @JsonProperty("currencyFrom") String currencyFrom,
            @JsonProperty("currencyTo") String currencyTo,
            @JsonProperty("amountSell") long amountSell,
            @JsonProperty("amountBuy") long amountBuy,
            @JsonProperty("rate") long rate,
            @JsonProperty("timePlaced") String timePlaced,
            @JsonProperty("originatingCountry") String originatingCountry) {
        this.user = user;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amountSell = amountSell;
        this.amountBuy = amountBuy;
        this.rate = rate;
        this.timePlaced = timePlaced;
        this.originatingCountry = originatingCountry;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public long getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(long amountSell) {
        this.amountSell = amountSell;
    }

    public long getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(long amountBuy) {
        this.amountBuy = amountBuy;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }
}
