package org.iscas.databean;

import java.math.BigDecimal;
import java.util.Date;

//订单信息的封装bean，Account

public class OrderDataBean {
	private Integer orderID;
	private String orderStatus;
	private Date openDate;
	private Date completionDate;
	private BigDecimal orderFee;
	private String orderType;
	private double quantity;
	private String symbol;
	private BigDecimal total;
	private BigDecimal price;

	public OrderDataBean() {

	}

	public OrderDataBean(Integer orderID, String orderStatus, Date openDate, Date completionDate, BigDecimal orderFee,
			String orderType, double quantity, String symbol, BigDecimal total, BigDecimal price) {
		this.orderID = orderID;
		this.orderStatus = orderStatus;
		this.openDate = openDate;
		this.completionDate = completionDate;
		this.orderFee = orderFee;
		this.orderType = orderType;
		this.quantity = quantity;
		this.symbol = symbol;
		this.total = total;
		this.price = price;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
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

	public BigDecimal getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(BigDecimal orderFee) {
		this.orderFee = orderFee;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
