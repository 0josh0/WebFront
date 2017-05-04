package org.iscas.entity;

/**
 * Created by andyren on 2016/6/28.
 */

public class AccountProfile implements java.io.Serializable {

	private String userID;
	private String fullName;
	private String creditCard;
	private String email;
	private String address;
	private String password;

	public AccountProfile() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountProfile(String userID, String fullName, String creditCard, String email, String address,
			String password) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.creditCard = creditCard;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.userID != null ? this.userID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof AccountProfile)) {
			return false;
		}
		AccountProfile other = (AccountProfile) object;
		if (this.userID != other.userID && (this.userID == null || !this.userID.equals(other.userID)))
			return false;
		return true;
	}
}
