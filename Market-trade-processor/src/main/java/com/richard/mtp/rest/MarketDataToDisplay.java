package com.richard.mtp.rest;

public class MarketDataToDisplay {

	private String eurAmount = "";
	private String usdAmount = "";
	private String gbpAmount = "";
	private String yenAmount = "";
	private String ausAmount = "";
	private String otherAmount = "";

	public MarketDataToDisplay(String eurAmount, String usdAmount,
			String gbpAmount, String yenAmount, String ausAmount,
			String otherAmount) {
		this.eurAmount = eurAmount;
		this.usdAmount = usdAmount;
		this.gbpAmount = gbpAmount;
		this.yenAmount = yenAmount;
		this.ausAmount = ausAmount;
		this.otherAmount = otherAmount;
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
}
