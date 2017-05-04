/**
 * 
 */
package org.iscas.databean;

import java.math.BigDecimal;

/**
 * @Title: QuoteBean
 * @Description:TODO
 * @author Summer
 * @date 2016年11月19日 下午3:38:44
 * 
 */
public class QuoteBean {

	private String symbol;
	private String companyName;
	private double volume;
	private BigDecimal price;
	private BigDecimal open1;
	private BigDecimal low;
	private BigDecimal high;
	private double change1;

	public QuoteBean(String symbol, String companyName, double volume, BigDecimal price, BigDecimal open1,
			BigDecimal low, BigDecimal high, double change1) {
		super();
		this.symbol = symbol;
		this.companyName = companyName;
		this.volume = volume;
		this.price = price;
		this.open1 = open1;
		this.low = low;
		this.high = high;
		this.change1 = change1;
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

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
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

	public void setChange1(double change1) {
		this.change1 = change1;
	}

	public QuoteBean() {
	}
}
