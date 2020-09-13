package com.harishtest.merchantdetails.merchantcompany.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bankdetails {
	
	private String Bankname;
	private String Accountnumber;
	private String IFSC;
	private Name AccountHolderName;
	@JsonProperty("MICRCode")
	private String micrcode;
	@JsonProperty("BankAddress")
	private Bankaddress bankaddress;
	public String getBankname() {
		return Bankname;
	}
	public void setBankname(String bankname) {
		Bankname = bankname;
	}
	public String getAccountnumber() {
		return Accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		Accountnumber = accountnumber;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public Name getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(Name accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	public String getMicrcode() {
		return micrcode;
	}
	public void setMicrcode(String micrcode) {
		this.micrcode = micrcode;
	}
	public Bankaddress getBankaddress() {
		return bankaddress;
	}
	public void setBankaddress(Bankaddress bankaddress) {
		this.bankaddress = bankaddress;
	}

}
