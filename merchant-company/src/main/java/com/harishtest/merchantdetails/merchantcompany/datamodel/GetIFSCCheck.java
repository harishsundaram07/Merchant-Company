package com.harishtest.merchantdetails.merchantcompany.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"_id", "STATE","BANK", "IFSC", "BRANCH", "ADDRESS", "CONTACT", "CITY", "DISTRICT", "MICRCODE" })
public class GetIFSCCheck {
	
	@JsonProperty("_id")
	private String _id;
	@JsonProperty("STATE")
	private String STATE;
	@JsonProperty("BANK")
	private String BANK;
	@JsonProperty("IFSC")
	private String IFSC;
	@JsonProperty("BRANCH")
	private String BRANCH;
	@JsonProperty("ADDRESS")
	private String ADDRESS;
	@JsonProperty("CONTACT")
	private String CONTACT;
	@JsonProperty("CITY")
	private String CITY;
	@JsonProperty("DISTRICT")
	private String DISTRICT;
	@JsonProperty("MICRCODE")
	private String MICRCODE;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getBANK() {
		return BANK;
	}
	public void setBANK(String bANK) {
		BANK = bANK;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getMICRCODE() {
		return MICRCODE;
	}
	public void setMICRCODE(String mICRCODE) {
		MICRCODE = mICRCODE;
	}

}
