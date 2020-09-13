package com.harishtest.merchantdetails.merchantcompany.dbfunctions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.harishtest.merchantdetails.merchantcompany.app.QueryConstants;
import com.harishtest.merchantdetails.merchantcompany.app.UserRepository;
import com.harishtest.merchantdetails.merchantcompany.datamapper.GetMerchantRowMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantRowMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Phone;

@Component
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	MerchantMapper mapper;
	
	@Override
	public int InsertMerchant(MerchantRequest merchreq) {
		//Insert Merchant into DB
		
		String query=QueryConstants.InsertQuery;
		String phone="";
		String phonetype="WORK";
		String accholdername="";
		String lastName="";
		String firstName="";
		String addressLine1="";
		String addressLine2="";
		String pincode="";
		String emailid="";
		String bankaccountnumber="";
		String city="";
		String state="";
		String country="";
		String DOB="";
		String bankname="";
		String ifsc="";
		if(merchreq.getMerchant()!=null)
			if(merchreq.getMerchant().getMerchantdetails()!=null)
				if(merchreq.getMerchant().getMerchantdetails().getContactDetails()!=null)
					for(Phone i : merchreq.getMerchant().getMerchantdetails().getContactDetails().getPhonedetails())
						if(i.getPhonetype().equalsIgnoreCase("WORK"))
							{
								phone=i.getCountrycode()+i.getPhoneno();
								break;
							}
		String mid=merchreq.getMerchant().getMerchantdetails().getMerchantid();		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		if(merchreq.getMerchant()!=null)
		{
			if(merchreq.getMerchant().getMerchantdetails()!=null)
		
				{
					 DOB= merchreq.getMerchant().getMerchantdetails().getDateofbirth();
						if(merchreq.getMerchant().getMerchantdetails().getName()!=null)
						{
							 lastName = merchreq.getMerchant().getMerchantdetails().getName().getLastname().isEmpty()? "" : merchreq.getMerchant().getMerchantdetails().getName().getLastname();
							 firstName= merchreq.getMerchant().getMerchantdetails().getName().getFirstname().isEmpty()? "" : merchreq.getMerchant().getMerchantdetails().getName().getFirstname();
						}
					if(merchreq.getMerchant().getMerchantdetails().getContactDetails()!=null)
					{
						if(merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress()!=null)
						{
							 addressLine1=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getAddressLine1();
							 addressLine2=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getAddressLine2();
							 pincode=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getZipcode();
							 city=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getCity();
							 state=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getState();
							 country=merchreq.getMerchant().getMerchantdetails().getContactDetails().getAddress().getCountry();
						
						}	
						 emailid=merchreq.getMerchant().getMerchantdetails().getContactDetails().getEmail();
					}
				}
			if(merchreq.getMerchant().getBankdetails()!=null)
			{	
					 bankaccountnumber=merchreq.getMerchant().getBankdetails().getAccountnumber();
					 bankname=merchreq.getMerchant().getBankdetails().getBankname();
					 ifsc=merchreq.getMerchant().getBankdetails().getIFSC();
					if(merchreq.getMerchant().getBankdetails().getAccountHolderName()!=null)
					{
						 accholdername=merchreq.getMerchant().getBankdetails().getAccountHolderName().getFirstname()+" "+merchreq.getMerchant().getBankdetails().getAccountHolderName().getLastname();
					}
							
			}
		}
			return jdbctemplate.update(query,accholdername,mid,lastName,firstName,addressLine1,addressLine2,phone,pincode,emailid,timestamp,bankaccountnumber,city,state,country,phonetype,DOB,bankname,ifsc);		
		
	}

	public MerchantRequest queryMerchantbyid(String mid) {
		
		RowMapper<Merchant>rowMapper=new GetMerchantRowMapper();
		List<Merchant> merchlist=jdbctemplate.query(QueryConstants.QuerybyId, rowMapper, mid);
		System.out.println(merchlist.size()!=0 ? "Print output : - "+merchlist.get(0): "no merchant found");
		MerchantRequest req=new MerchantRequest();
		req.setMerchant(merchlist.size()!=0 ? merchlist.get(0):null);
		return req;
		
	}

	@Override
	public int SeqID() 
	{
 		int update=jdbctemplate.update(QueryConstants.UpdateSEQID);
		return jdbctemplate.queryForObject(QueryConstants.QuerySEQID,Integer.class);
	}

	@Override
	public List<Merchant> queryMerchantbyphone(Merchant merchant) {
		
		RowMapper<Merchant> rowmapper= new MerchantRowMapper();
		String phone="";
		if(merchant.getMerchantdetails()!=null)
		if(merchant.getMerchantdetails().getContactDetails()!=null)
			for(Phone i : merchant.getMerchantdetails().getContactDetails().getPhonedetails())
				if(i.getPhonetype().equalsIgnoreCase("WORK"))
					{
						phone=i.getCountrycode()+i.getPhoneno();
						break;
					}
			
		String bankaccnumber=!merchant.getBankdetails().getAccountnumber().isEmpty() ? merchant.getBankdetails().getAccountnumber() :"";
		
		
		return jdbctemplate.query(QueryConstants.Querybyphone, rowmapper, phone,bankaccnumber);
	}

	@Override
	public List<Merchant> queryAllbyphone(String phone) {
		
		List<Merchant> response=new ArrayList<Merchant>();
		RowMapper<Merchant> rowMapper=new GetMerchantRowMapper();
		response=jdbctemplate.query(QueryConstants.QueryAllbyphone, rowMapper, phone);	
		return response;
	}
	
	


}
