package org.iscas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by andyren on 2016/6/28.
 */

public class Holding implements Serializable {

	private Integer holdingID;

	private Double quantity;

	private BigDecimal purchasePrice;

	private Date purchaseDate;

	private String quoteSymbol;

	private Integer accountID;

	public Holding() {
	}

	public Holding(Integer holdingID, Double quantity, BigDecimal purchasePrice, Date purchaseDate,
			String quoteSymbol) {
		setHoldingID(holdingID);
		setQuantity(quantity);
		setPurchasePrice(purchasePrice);
		setPurchaseDate(purchaseDate);
		setQuoteSymbol(quoteSymbol);
	}

	public Holding(Double quantity, BigDecimal purchasePrice, Date purchaseDate, Integer accountID,
			String quoteSymbol) {
		setQuantity(quantity);
		setPurchasePrice(purchasePrice);
		setPurchaseDate(purchaseDate);
		setAccountID(accountID);
		setQuoteSymbol(quoteSymbol);
	}

	public String toString() {
		return "\n\tHolding Data for holding: " + getHoldingID() + "\n\t\t      quantity:" + getQuantity()
				+ "\n\t\t purchasePrice:" + getPurchasePrice() + "\n\t\t  purchaseDate:" + getPurchaseDate()
				+ "\n\t\t       quoteID:" + getQuoteSymbol();
	}

	public String toHTML() {
		return "<BR>Holding Data for holding: " + getHoldingID() + "</B>" + "<LI>      quantity:" + getQuantity()
				+ "</LI>" + "<LI> purchasePrice:" + getPurchasePrice() + "</LI>" + "<LI>  purchaseDate:"
				+ getPurchaseDate() + "</LI>" + "<LI>       quoteID:" + getQuoteSymbol() + "</LI>";
	}

	public Integer getHoldingID() {
		return holdingID;
	}

	public void setHoldingID(Integer holdingID) {
		this.holdingID = holdingID;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getQuoteSymbol() {
		return quoteSymbol;
	}

	public void setQuoteSymbol(String quoteSymbol) {
		this.quoteSymbol = quoteSymbol;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.holdingID != null ? this.holdingID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Holding)) {
			return false;
		}
		Holding other = (Holding) object;
		if (this.holdingID != other.holdingID && (this.holdingID == null || !this.holdingID.equals(other.holdingID)))
			return false;
		return true;
	}
}
