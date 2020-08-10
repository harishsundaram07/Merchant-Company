package com.harishtest.merchantdetails.merchantcompany.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.harishtest.merchantdetails.merchantcompany.datamodel.Address;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Bankdetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.ContactDetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantDetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Name;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Phone;

public class GetMerchantRowMapper implements RowMapper<Merchant> {

	@Override
	public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Merchant merchant=new Merchant();
		ContactDetails contact=new ContactDetails();
		Name name=new Name();
		Address address=new Address();
		Phone phone=new Phone();
		List<Phone> phonedetails=new ArrayList<Phone>();
		Bankdetails bank=new Bankdetails();
		MerchantDetails details=new MerchantDetails();
		if(rs.getString("FirstName") != null)
		name.setFirstname(rs.getString("FirstName"));
		if(rs.getString("LastName") != null)
		name.setLastname(rs.getString("LastName"));
		if(rs.getString("AddressLine1") != null)
		address.setAddressLine1(rs.getString("AddressLine1"));
		if(rs.getString("AddressLine2") != null)
		address.setAddressLine2(rs.getString("AddressLine2"));
		if(rs.getString("City") != null)
		address.setCity(rs.getString("City"));
		if(rs.getString("Country") != null)
		address.setCountry(rs.getString("Country"));
		if(rs.getString("State") != null)
		address.setState(rs.getString("State"));
		if(rs.getString("Phoneno") != null)
		phone.setCountrycode(rs.getString("Phoneno").substring(0,3));
		if(rs.getString("PHONETYPE") != null)
		phone.setPhonetype(rs.getString("PHONETYPE"));
		if(rs.getString("Phoneno") != null)
		phone.setPhoneno(rs.getString("Phoneno").substring(3));
		if(phone!=null)
		phonedetails.add(phone);
		  if(phonedetails!=null)
		contact.setPhonedetails(phonedetails);
		  if(address!=null)
		contact.setAddress(address);
		if(rs.getString("EmailId") != null)
		contact.setEmail(rs.getString("EmailId"));
		details.setContactDetails(contact);
		if(rs.getString("MerchantID") != null)
		details.setMerchantid(rs.getString("MerchantID"));
		if(rs.getString("DOB") != null)
		details.setDateofbirth(rs.getString("DOB"));
		  if(name!=null)
		  details.setName(name); 
		  if(rs.getString("ACCHOLDERNAME") != null)
		  {
			  String[] str=new String[2];
		  
		  str=rs.getString("ACCHOLDERNAME").split(" ");
		  name.setFirstname(str[0]);
		  name.setLastname(str[1]); 
		  bank.setAccountHolderName(name);
		  }
		  if(rs.getString("BankAccountNumber") != null)
		bank.setAccountnumber(rs.getString("BankAccountNumber"));
		  if(rs.getString("BankName") != null)
		bank.setBankname(rs.getString("BankName"));
		  if(rs.getString("IFSC") != null)
		bank.setIFSC(rs.getString("IFSC"));
		  if(bank!=null)
		merchant.setBankdetails(bank);
		  if(details!=null)
		merchant.setMerchantdetails(details);
		
		return merchant;
	}

}
