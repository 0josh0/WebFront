/**
 * 
 */
package org.iscas.databean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: OrderBean
 * @Description:TODO
 * @author Summer
 * @date 2016年11月19日 下午4:54:57
 * 
 */
public class OrderBean {

	private Integer orderID;
	private String orderType;
	private String orderStatus;
	private Date openDate;
	private Date completionDate;
	private Double quantity;
	private BigDecimal price;
	private BigDecimal orderFee;
	private String quoteSymbol;
	private Integer accountID;
	private Integer holdingID;

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(BigDecimal orderFee) {
		this.orderFee = orderFee;
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

	public Integer getHoldingID() {
		return holdingID;
	}

	public void setHoldingID(Integer holdingID) {
		this.holdingID = holdingID;
	}

	public OrderBean(Integer orderID, String orderType, String orderStatus, Date openDate, Date completionDate,
			Double quantity, BigDecimal price, BigDecimal orderFee, String quoteSymbol, Integer accountID,
			Integer holdingID) {
		super();
		this.orderID = orderID;
		this.orderType = orderType;
		this.orderStatus = orderStatus;
		this.openDate = openDate;
		this.completionDate = completionDate;
		this.quantity = quantity;
		this.price = price;
		this.orderFee = orderFee;
		this.quoteSymbol = quoteSymbol;
		this.accountID = accountID;
		this.holdingID = holdingID;
	}

	public OrderBean() {
	}

}
