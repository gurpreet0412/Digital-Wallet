package com.celcom.wallet.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateWalletReq {
	
	private String customerid;
	private String initiateBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date initiateTime;
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

	
	// create wallet krnge to kya kya fields hum request krnge
}
