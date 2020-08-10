package com.harishtest.merchantdetails.merchantcompany.datamapper;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Address;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Bankdetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.ContactDetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Errors;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Infos;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantDetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Name;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Phone;
import com.harishtest.merchantdetails.merchantcompany.datamodel.ResponseDetails;

@Component
@ConfigurationProperties(prefix="test.filepath")
public class TestObjectMapper {
	
	private Merchant merchant= new Merchant();
	private MerchantDetails details=new MerchantDetails();
	private Bankdetails bank=new Bankdetails();
	private MerchantRequest request= new MerchantRequest();
	private MerchantResponse response= new MerchantResponse();
	private MerchantResponseAll responseall= new MerchantResponseAll();
	private ContactDetails contact= new ContactDetails();
	private Address address= new Address();
	private Phone phone = new Phone();
	private Name name= new Name();
	private ResponseDetails responsedetails= new ResponseDetails();
	private Errors error= new Errors();
	private Infos infos= new Infos();
	private String ResponseFileName;
	private String RequestFileName;
	private String MerchantsFileName;
	private String ResponseAllFileName;
	
	
	public String getResponseAllFileName() {
		return ResponseAllFileName;
	}

	public void setResponseAllFileName(String responseAllFileName) {
		ResponseAllFileName = responseAllFileName;
	}

	public String getResponseFileName() {
		return ResponseFileName;
	}

	public void setResponseFileName(String responseFileName) {
		ResponseFileName = responseFileName;
	}

	public String getRequestFileName() {
		return RequestFileName;
	}

	public void setRequestFileName(String requestFileName) {
		RequestFileName = requestFileName;
	}

	public String getMerchantsFileName() {
		return MerchantsFileName;
	}

	public void setMerchantsFileName(String merchantsFileName) {
		MerchantsFileName = merchantsFileName;
	}

	public MerchantRequest Request( String mid)
	{
		phone.setCountrycode("+91");
		phone.setPhoneno("9326715657");
		phone.setPhonetype("WORK");
		address.setAddressLine1("E-23 Sai Garden");
		address.setAddressLine2("Ghansoli");
		address.setCity("Thane");
		address.setCountry("IN");
		address.setState("MH");
		name.setFirstname("C.K");
		name.setLastname("Sundaram");
		List<Phone> phonedetails= new ArrayList<Phone>();
		phonedetails.add(phone);
		contact.setAddress(address);
		contact.setEmail("HARISH@GMAIL.COM");
		contact.setPhonedetails(phonedetails);
		details.setContactDetails(contact);
		details.setName(name);
		details.setDateofbirth("09/12/1998");
		details.setMerchantid(mid);
		bank.setAccountHolderName(name);
		bank.setAccountnumber("110912090903");
		bank.setBankname("Axis Bank Ltd");
		bank.setIFSC("UTIB00701");
		merchant.setBankdetails(bank);
		merchant.setMerchantdetails(details);
		request.setMerchant(merchant);
		return request;
		
	}
	
	public MerchantResponse Response(String mid, String status)
	{
		phone.setCountrycode("+91");
		phone.setPhoneno("9326715657");
		phone.setPhonetype("WORK");
		address.setAddressLine1("E-23 Sai Garden");
		address.setAddressLine2("Ghansoli");
		address.setCity("Thane");
		address.setCountry("IN");
		address.setState("MH");
		name.setFirstname("C.K");
		name.setLastname("Sundaram");
		List<Phone> phonedetails= new ArrayList<Phone>();
		phonedetails.add(phone);
		contact.setAddress(address);
		contact.setEmail("HARISH@GMAIL.COM");
		contact.setPhonedetails(phonedetails);
		details.setContactDetails(contact);
		details.setName(name);
		details.setDateofbirth("09/12/1998");
		details.setMerchantid(mid);
		bank.setAccountHolderName(name);
		bank.setAccountnumber("110912090903");
		bank.setBankname("Axis Bank Ltd");
		bank.setIFSC("UTIB00701");
		merchant.setBankdetails(bank);
		merchant.setMerchantdetails(details);
		response.setMerchant(merchant); 
		if(status.equalsIgnoreCase("FAILED"))
		{
			error.setErrorcode("400");
			error.setErrormessage("OK");
			error.setStacktrace("");
			responsedetails.setError(error);
			responsedetails.setStatus("FAILED");
		}
		else
		{
			infos.setCode("200");
			infos.setMsg("OK");
			responsedetails.setInfo(infos);
			responsedetails.setStatus("SUCCESS");
		}
		response.setResponsedetails(responsedetails);
		return response;
	}
	
	
	public Merchant Merchants(String mid)
	{
		phone.setCountrycode("+91");
		phone.setPhoneno("9326715657");
		phone.setPhonetype("WORK");
		address.setAddressLine1("E-23 Sai Garden");
		address.setAddressLine2("Ghansoli");
		address.setCity("Thane");
		address.setCountry("IN");
		address.setState("MH");
		name.setFirstname("C.K");
		name.setLastname("Sundaram");
		List<Phone> phonedetails= new ArrayList<Phone>();
		phonedetails.add(phone);
		contact.setAddress(address);
		contact.setEmail("HARISH@GMAIL.COM");
		contact.setPhonedetails(phonedetails);
		details.setContactDetails(contact);
		details.setName(name);
		details.setDateofbirth("09/12/1998");
		details.setMerchantid(mid);
		bank.setAccountHolderName(name);
		bank.setAccountnumber("110912090903");
		bank.setBankname("Axis Bank Ltd");
		bank.setIFSC("UTIB00701");
		merchant.setBankdetails(bank);
		merchant.setMerchantdetails(details);
		return merchant;
		
	}
	
	public MerchantResponseAll ResponseAll(String phoneno)
	{

		phone.setCountrycode("+91");
		phone.setPhoneno(phoneno);
		phone.setPhonetype("WORK");
		address.setAddressLine1("E-23 Sai Garden");
		address.setAddressLine2("Ghansoli");
		address.setCity("Thane");
		address.setCountry("IN");
		address.setState("MH");
		name.setFirstname("C.K");
		name.setLastname("Sundaram");
		List<Phone> phonedetails= new ArrayList<Phone>();
		phonedetails.add(phone);
		contact.setAddress(address);
		contact.setEmail("HARISH@GMAIL.COM");
		contact.setPhonedetails(phonedetails);
		details.setContactDetails(contact);
		details.setName(name);
		details.setDateofbirth("09/12/1998");
		details.setMerchantid("20201026");
		bank.setAccountHolderName(name);
		bank.setAccountnumber("110912090903");
		bank.setBankname("Axis Bank Ltd");
		bank.setIFSC("UTIB00701");
		merchant.setBankdetails(bank);
		merchant.setMerchantdetails(details);
		List<Merchant> list=new ArrayList<Merchant>();
		list.add(merchant);
		list.add(merchant);
		responseall.setAllMerchant(list); 
		infos.setCode("200");
		infos.setMsg("OK");
		responsedetails.setInfo(infos);
		responsedetails.setStatus("SUCCESS");
		responseall.setResponsedetails(responsedetails);
		return responseall;
		
	}
	public void MerchantResponseJson(MerchantResponse response1) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		
		ObjectMapper objectMapper = new ObjectMapper();
		String expected=objectMapper.writeValueAsString(objectMapper.readValue(new File(ResponseFileName), MerchantResponse.class));
		assertEquals(expected,objectMapper.writeValueAsString(response1)); 	

	}
	public void MerchantJson(Merchant merchant1) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String expected=objectMapper.writeValueAsString(objectMapper.readValue(new File(MerchantsFileName), Merchant.class));
		assertEquals(expected,objectMapper.writeValueAsString(merchant1)); 	

	}
	public void MerchantReequestJson(MerchantRequest request1) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String expected=objectMapper.writeValueAsString(objectMapper.readValue(new File(RequestFileName), MerchantRequest.class));
		assertEquals(expected,objectMapper.writeValueAsString(request1)); 	

	}

	public void ResponseAllJson(MerchantResponseAll responseall1) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String expected=objectMapper.writeValueAsString(objectMapper.readValue(new File(ResponseAllFileName), MerchantResponseAll.class));
		assertEquals(expected,objectMapper.writeValueAsString(responseall1)); 	

	}
	
	

}
