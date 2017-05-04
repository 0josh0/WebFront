package org.iscas.databean;

//quotes&Trade面板信息封装bean

import java.math.BigDecimal;

public class QuoteDataBean {
	private BigDecimal currentPrice;
	private BigDecimal openPrice;
	private String symbol;
	private BigDecimal high;
	private BigDecimal low;
	private String companyName;
	private double volume;
	private double change;
	private String range;
	private BigDecimal gainPercent;
	private BigDecimal gain;

	public QuoteDataBean() {
	}

	public QuoteDataBean(BigDecimal currentPrice, BigDecimal openPrice, String symbol, BigDecimal high, BigDecimal low,
			String companyName, double volume, double change, String range, BigDecimal gainPercent, BigDecimal gain) {
		this.currentPrice = currentPrice;
		this.openPrice = openPrice;
		this.symbol = symbol;
		this.high = high;
		this.low = low;
		this.companyName = companyName;
		this.volume = volume;
		this.change = change;
		this.range = range;
		this.gainPercent = gainPercent;
		this.gain = gain;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public BigDecimal getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public BigDecimal getGainPercent() {
		return gainPercent;
	}

	public void setGainPercent(BigDecimal gainPercent) {
		this.gainPercent = gainPercent;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}
}
