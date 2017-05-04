package org.iscas.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by andyren on 2016/6/28.
 */
public class Quote implements Serializable {

	private String symbol;

	private String companyName;

	private double volume;

	private BigDecimal price;

	private BigDecimal open1;

	private BigDecimal low;

	private BigDecimal high;

	private double change1;

	public Quote() {
	}

	public Quote(String symbol, String companyName, double volume, BigDecimal price, BigDecimal open1, BigDecimal low,
			BigDecimal high, double change1) {
		setSymbol(symbol);
		setCompanyName(companyName);
		setVolume(volume);
		setPrice(price);
		setOpen1(open1);
		setLow(low);
		setHigh(high);
		setChange1(change1);
	}

	// Create a "zero" value quoteDataBean for the given symbol
	public Quote(String symbol) {
		setSymbol(symbol);
	}

	public String toString() {
		return "\n\tQuote Data for: " + getSymbol() + "\n\t\t companyName: " + getCompanyName() + "\n\t\t      volume: "
				+ getVolume() + "\n\t\t       price: " + getPrice() + "\n\t\t        open1: " + getOpen1()
				+ "\n\t\t         low: " + getLow() + "\n\t\t        high: " + getHigh() + "\n\t\t      change1: "
				+ getChange1();
	}

	public String toHTML() {
		return "<BR>Quote Data for: " + getSymbol() + "<LI> companyName: " + getCompanyName() + "</LI>"
				+ "<LI>      volume: " + getVolume() + "</LI>" + "<LI>       price: " + getPrice() + "</LI>"
				+ "<LI>        open1: " + getOpen1() + "</LI>" + "<LI>         low: " + getLow() + "</LI>"
				+ "<LI>        high: " + getHigh() + "</LI>" + "<LI>      change1: " + getChange1() + "</LI>";
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOpen1() {
		return open1;
	}

	public void setOpen1(BigDecimal open1) {
		this.open1 = open1;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public double getChange1() {
		return change1;
	}

	public void setChange1(double change) {
		this.change1 = change;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.symbol != null ? this.symbol.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Quote)) {
			return false;
		}
		Quote other = (Quote) object;
		if (this.symbol != other.symbol && (this.symbol == null || !this.symbol.equals(other.symbol)))
			return false;
		return true;
	}

	/**
	 * 应该重新生成�?种随机报价生成策略，使股票在�?定的价格周期内波动�??
	 * 
	 * @return
	 */
	public static Quote getRandomInstance() {
		Quote quote = new Quote();

		return quote;
	}

}
