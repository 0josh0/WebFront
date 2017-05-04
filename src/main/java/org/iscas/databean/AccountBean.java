/**
 * 
 */
package org.iscas.databean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: AccountBean
 * @Description:TODO
 * @author Summer
 * @date 2016年11月19日 上午12:17:24
 * 
 */
public class AccountBean {

	private Integer accountID;
	private String profileUserID;
	private BigDecimal balance;
	private BigDecimal openBalance;
	private Date creationDate;
	private Date lastLogin;
	private Integer loginCount;
	private Integer logoutCount;

	public AccountBean(Integer accountID, String profileUserID, BigDecimal balance, BigDecimal openBalance,
			Date creationDate, Date lastLogin, Integer loginCount, Integer logoutCount) {
		super();
		this.accountID = accountID;
		this.profileUserID = profileUserID;
		this.balance = balance;
		this.openBalance = openBalance;
		this.creationDate = creationDate;
		this.lastLogin = lastLogin;
		this.loginCount = loginCount;
		this.logoutCount = logoutCount;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public String getProfileUserID() {
		return profileUserID;
	}

	public void setProfileUserID(String profileUserID) {
		this.profileUserID = profileUserID;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getLogoutCount() {
		return logoutCount;
	}

	public void setLogoutCount(Integer logoutCount) {
		this.logoutCount = logoutCount;
	}

	public AccountBean() {
	}
}
