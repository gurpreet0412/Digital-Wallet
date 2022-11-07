package com.celcom.wallet.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateWalletResponse {
	private String customerid;
	private String initiateBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date initiateTime;
	
	private String walletId;
	
	
	public CreateWalletResponse() {
		
	}
	public CreateWalletResponse(String customerid, String initiateBy, Date initiateTime, String walletId) {
		super();
		this.customerid = customerid;
		this.initiateBy = initiateBy;
		this.initiateTime = initiateTime;
		this.walletId = walletId;
	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getInitiateBy() {
		return initiateBy;
	}
	public void setInitiateBy(String initiateBy) {
		this.initiateBy = initiateBy;
	}
	public Date getInitiateTime() {
		return initiateTime;
	}
	public void setInitiateTime(Date initiateTime) {
		this.initiateTime = initiateTime;
	}

}
