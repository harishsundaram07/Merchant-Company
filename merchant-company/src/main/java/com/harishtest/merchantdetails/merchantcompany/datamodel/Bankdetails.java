package com.harishtest.merchantdetails.merchantcompany.datamodel;

public class Bankdetails {
	
	private String Bankname;
	private String Accountnumber;
	private String IFSC;
	private Name AccountHolderName;
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

}
