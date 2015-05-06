package com.richard.mtp.web;

public class MarketDataToDisplay {

	private String eurAmount = "";
	private String usdAmount = "";
	private String gbpAmount = "";
	private String yenAmount = "";
	private String ausAmount = "";
	private String otherAmount = "";
	private String noOfTransactions = "";

	public MarketDataToDisplay(String eurAmount, String usdAmount,
			String gbpAmount, String yenAmount, String ausAmount,
			String otherAmount, String noOfTransactions) {
		this.eurAmount = eurAmount;
		this.usdAmount = usdAmount;
		this.gbpAmount = gbpAmount;
		this.yenAmount = yenAmount;
		this.ausAmount = ausAmount;
		this.otherAmount = otherAmount;
		this.noOfTransactions = noOfTransactions;
	}

	public String getEurAmount() {
		return eurAmount;
	}

	public String getGbpAmount() {
		return gbpAmount;
	}

	public String getUsdAmount() {
		return usdAmount;
	}

	public String getYenAmount() {
		return yenAmount;
	}

	public String getAusAmount() {
		return ausAmount;
	}

	public String getOtherAmount() {
		return otherAmount;
	}

	public String getNoOfTransactions() {
		return noOfTransactions;
	}
}
