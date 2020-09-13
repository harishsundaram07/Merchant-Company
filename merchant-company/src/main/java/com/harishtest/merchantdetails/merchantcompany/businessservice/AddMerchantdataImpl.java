package com.harishtest.merchantdetails.merchantcompany.businessservice;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harishtest.merchantdetails.merchantcompany.app.AddMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.GetMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.UserRepository;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;

@Component
public class AddMerchantdataImpl implements AddMerchant {

	@Autowired
	UserRepository userrepository;
	@Autowired
	MerchantMapper mapper;
	@Autowired
	GetMerchant getmerchant;


	@Override
	public MerchantResponse AddMerchantdata(MerchantRequest merchreq) {

		MerchantResponse resp = new MerchantResponse();
		resp = ValidationCheck(merchreq);
		if(resp.getResponsedetails().getStatus().equalsIgnoreCase("SUCCESS"))
		resp=getmerchant.GetIFSCDetails(merchreq);
		else
			return resp;
		if(resp.getResponsedetails().getStatus().equalsIgnoreCase("SUCCESS")) {
		 String mid = Year.now().toString() + String.valueOf(userrepository.SeqID());
		 merchreq.getMerchant().getMerchantdetails().setMerchantid(mid);
		int update = userrepository.InsertMerchant(merchreq);
		MerchantResponse response = new MerchantResponse();
		if (update > 0)
			{
				response = mapper.GetMerchantResponseMapper(merchreq, "SUCCESS", "200","Merchant " + mid + "  added successfully.","");
			}
					
		else {
			merchreq.getMerchant().getMerchantdetails().setMerchantid("");
			response = mapper.GetMerchantResponseMapper(merchreq, "Failed", "400", "Merchant creation failed.","");
		}

		return response;
		
		  } 
		  else 
			  return resp;
		 
	}

	@Override
	public MerchantResponse ValidationCheck(MerchantRequest merchreq) {
		MerchantResponse merchresponse = new MerchantResponse();
		if (merchreq.getMerchant() != null) 
		{
			if (merchreq.getMerchant().getMerchantdetails() != null)

			{
				if (merchreq.getMerchant().getMerchantdetails().getContactDetails()!=null)
				{
					if (merchreq.getMerchant().getMerchantdetails().getContactDetails().getPhonedetails() != null)
					{
						if(merchreq.getMerchant().getBankdetails()!=null)
						{
							List<Merchant> merchant = userrepository.queryMerchantbyphone(merchreq.getMerchant());
							if (merchant.size()==0)
								merchresponse = mapper.GetMerchantResponseMapper(merchreq, "Success", "VALIDATION Success",
										"valid data combination.","");
							else
								merchresponse = mapper.GetMerchantResponseMapper(merchreq, "Failed", "VALIDATION ERROR",
										"The Merchant combination of mobile number & bank account numer already exists.","");
						}
						else
							{
							merchresponse = mapper.GetMerchantResponseMapper(merchreq, "FAILED", "VALIDATION ERROR",
									"No bank details provided.","");
							}
					} 
					else 
						{
						merchresponse = mapper.GetMerchantResponseMapper(merchreq, "FAILED", "VALIDATION ERROR",
								"No phone details present.","");
						}
			}
				else
					merchresponse = mapper.GetMerchantResponseMapper(merchreq, "FAILED", "VALIDATION ERROR",
							"No Contact details present.","");
			}
			else
				merchresponse = mapper.GetMerchantResponseMapper(merchreq, "FAILED", "NULLVALUE",
						"No merchant details present.","");
		} 
		else
			merchresponse = mapper.GetMerchantResponseMapper(merchreq, "FAILED", "NULLVALUE",
					"No merchant details present.","");

		return merchresponse;
	}

}
