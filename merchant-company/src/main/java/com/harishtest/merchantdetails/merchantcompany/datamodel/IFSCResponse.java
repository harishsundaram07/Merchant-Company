package com.harishtest.merchantdetails.merchantcompany.datamodel;

public class IFSCResponse {
	
	private String status;
	private GetIFSCCheck data;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public GetIFSCCheck getData() {
		return data;
	}
	public void setData(GetIFSCCheck data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
