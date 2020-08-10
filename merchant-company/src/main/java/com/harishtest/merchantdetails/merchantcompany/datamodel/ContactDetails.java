package com.harishtest.merchantdetails.merchantcompany.datamodel;

import java.util.List;


public class ContactDetails {
	private List<Phone> phonedetails;
	private Address address;
	private String email;
	
	public List<Phone> getPhonedetails() {
		return phonedetails;
	}
	public void setPhonedetails(List<Phone> phonedetails) {
		this.phonedetails = phonedetails;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
