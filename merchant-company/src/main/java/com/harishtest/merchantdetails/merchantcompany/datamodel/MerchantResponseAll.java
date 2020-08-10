package com.harishtest.merchantdetails.merchantcompany.datamodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantResponseAll {
	
	@JsonProperty("MerchantList")
	private List<Merchant> allMerchant;
	@JsonProperty("ResponseDetails")
	private ResponseDetails responsedetails;
	public List<Merchant> getAllMerchant() {
		return allMerchant;
	}
	public void setAllMerchant(List<Merchant> allMerchant) {
		this.allMerchant = allMerchant;
	}
	public ResponseDetails getResponsedetails() {
		return responsedetails;
	}
	public void setResponsedetails(ResponseDetails responsedetails) {
		this.responsedetails = responsedetails;
	}
	

}
