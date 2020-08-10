package com.harishtest.merchantdetails.merchantcompany.datamodel;

public class ResponseDetails {
	
	private String status;
	private Infos info;
	private Errors error;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Errors getError() {
		return error;
	}
	public void setError(Errors error) {
		this.error = error;
	}
	public Infos getInfo() {
		return info;
	}
	public void setInfo(Infos info) {
		this.info = info;
	}
	
	

}
