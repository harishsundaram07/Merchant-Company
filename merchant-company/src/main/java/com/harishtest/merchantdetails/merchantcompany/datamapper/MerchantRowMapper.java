package com.harishtest.merchantdetails.merchantcompany.datamapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.harishtest.merchantdetails.merchantcompany.datamodel.Bankdetails;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantDetails;

public class MerchantRowMapper implements RowMapper<Merchant> {

	@Override
	public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Merchant merchant=new Merchant();
		MerchantDetails details=new MerchantDetails();
		
		if(!rs.getString("MerchantID").isEmpty())
		details.setMerchantid(rs.getString("MerchantID"));
		Bankdetails bank= new Bankdetails();
		if(!rs.getString("BANKAccountNumber").isEmpty())
		 bank.setAccountnumber(rs.getString("BANKAccountNumber")); 
		merchant.setMerchantdetails(details);
		 merchant.setBankdetails(bank); 
		return merchant;
	}

}
