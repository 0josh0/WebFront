package org.iscas.databean;

import java.math.BigDecimal;
import java.util.Date;

import org.iscas.entity.Orders;

//Trade:
//Account和Home面板上信息的封装bean，账户信息

public class AccountDataBean {
	private Date sessionCreationDate;// session creaded Time
	private Date currentTime;// login time
	private String profileID; // userid
	private Integer accountID;// Account ID
	private Date creationDate;// Account created time
	private int loginCount;// totals logins
	private Date lastLogin;// last Login
	private int logoutCount;// totals logout
	private BigDecimal balance;// cash balance
	private BigDecimal openBalance; // opening balance

	private Integer numberHoldings;// number of holdings
	private BigDecimal holdingsTotal;// total of holdings
	private BigDecimal sumOfCashHoldings;// sum of cash/holdingss
	private BigDecimal gain;// crrent gain
	private BigDecimal gainPercent;

	private Orders[] closedOrders;
	private Orders[] allOrders;

	public AccountDataBean(Date sessionCreationDate, Date currentTime, String profileID, Integer accountID,
			Date creationDate, int loginCount, Date lastLogin, int logoutCount, BigDecimal balance,
			BigDecimal openBalance, Integer numberHoldings, BigDecimal holdingsTotal, BigDecimal sumOfCashHoldings,
			BigDecimal gain, BigDecimal gainPercent, Orders[] closedOrders, Orders[] allOrders) {
		super();
		this.sessionCreationDate = sessionCreationDate;
		this.currentTime = currentTime;
		this.profileID = profileID;
		this.accountID = accountID;
		this.creationDate = creationDate;
		this.loginCount = loginCount;
		this.lastLogin = lastLogin;
		this.logoutCount = logoutCount;
		this.balance = balance;
		this.openBalance = openBalance;
		this.numberHoldings = numberHoldings;
		this.holdingsTotal = holdingsTotal;
		this.sumOfCashHoldings = sumOfCashHoldings;
		this.gain = gain;
		this.gainPercent = gainPercent;
		this.closedOrders = closedOrders;
		this.allOrders = allOrders;
	}

	public Date getSessionCreationDate() {
		return sessionCreationDate;
	}

	public void setSessionCreationDate(Date sessionCreationDate) {
		this.sessionCreationDate = sessionCreationDate;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getLogoutCount() {
		return logoutCount;
	}

	public void setLogoutCount(int logoutCount) {
		this.logoutCount = logoutCount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(BigDecimal openBalance) {
		this.openBalance = openBalance;
	}

	public Integer getNumberHoldings() {
		return numberHoldings;
	}

	public void setNumberHoldings(Integer numberHoldings) {
		this.numberHoldings = numberHoldings;
	}

	public BigDecimal getHoldingsTotal() {
		return holdingsTotal;
	}

	public void setHoldingsTotal(BigDecimal holdingsTotal) {
		this.holdingsTotal = holdingsTotal;
	}

	public BigDecimal getSumOfCashHoldings() {
		return sumOfCashHoldings;
	}

	public void setSumOfCashHoldings(BigDecimal sumOfCashHoldings) {
		this.sumOfCashHoldings = sumOfCashHoldings;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	public BigDecimal getGainPercent() {
		return gainPercent;
	}

	public void setGainPercent(BigDecimal gainPercent) {
		this.gainPercent = gainPercent;
	}

	public Orders[] getClosedOrders() {
		return closedOrders;
	}

	public void setClosedOrders(Orders[] closedOrders) {
		this.closedOrders = closedOrders;
	}

	public Orders[] getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(Orders[] allOrders) {
		this.allOrders = allOrders;
	}

	public AccountDataBean() {
	}
}
