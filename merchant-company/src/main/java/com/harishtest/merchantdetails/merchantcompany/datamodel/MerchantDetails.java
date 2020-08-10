package com.harishtest.merchantdetails.merchantcompany.datamodel;

public class MerchantDetails {
	private String merchantid;
	private ContactDetails ContactDetails;
	private Name name;
	private String Dateofbirth;
	
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public ContactDetails getContactDetails() {
		return ContactDetails;
	}
	public void setContactDetails(ContactDetails contactDetails) {
		ContactDetails = contactDetails;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getDateofbirth() {
		return Dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		Dateofbirth = dateofbirth;
	}

}
