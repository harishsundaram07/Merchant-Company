package com.harishtest.merchantdetails.merchantcompany.businessservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harishtest.merchantdetails.merchantcompany.app.GetMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.MerchantDataService;
import com.harishtest.merchantdetails.merchantcompany.app.UserRepository;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Bankaddress;
import com.harishtest.merchantdetails.merchantcompany.datamodel.IFSCResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;

@Component

public  class GetMerchantImpl implements GetMerchant {

	@Autowired
	MerchantMapper getmapper;
	@Autowired
	UserRepository userrepository;	
	@Autowired
	MerchantDataService dataservice;
	
	

	@Override
	public MerchantResponse GetmerchantbyID(String mid){
		MerchantRequest merchreq=userrepository.queryMerchantbyid(mid);
		String msg=merchreq.getMerchant()!=null ? "Merchant "+mid+" found successfully." : "Merchant "+mid+" not found." ;
		System.out.println(msg); 
		String code=merchreq.getMerchant()!=null ? "200" :"404";
		String status=merchreq.getMerchant()!=null ? "Success" :"Failed";
		return getmapper.GetMerchantResponseMapper(merchreq,status,code,msg,"");
	}



	@Override
	public MerchantResponseAll GetMerchantByPhone(String phone) {
		
		if(phone.startsWith("91") && phone.length()==12)
			phone="+"+phone;
		else if(!phone.startsWith("+91") || phone.length()==10)
			phone="+91"+phone;
		
		System.out.println("phoneno.- "+phone+" . ");
		
		List<Merchant> merchlist=new ArrayList<Merchant>();
		merchlist=userrepository.queryAllbyphone(phone);
		String code=merchlist.size()>0 ? "200":"NO-RECORD-FOUND";
		String msg=merchlist.size()>0 ?"All merchants found successfully for phone number:- "+phone+" .":"No record found for phone number:- "+phone+" .";
		System.out.println(code+" - " +msg);
		return getmapper.GetAllMapper(merchlist,merchlist.size()>0 ?"SUCCESS":"FAILED",code,msg,"");
	}
	
	@Override
	public MerchantResponse GetIFSCDetails(MerchantRequest req)
	{
		if(req.getMerchant().getBankdetails()!=null && req.getMerchant().getBankdetails().getIFSC()!=null)
		{
			IFSCResponse ifscresponse=dataservice.GetIFSCDetails(req.getMerchant().getBankdetails().getIFSC());
			if(ifscresponse.getStatus().equalsIgnoreCase("SUCCESS") && ifscresponse.getData()!=null)
				{
					req.getMerchant().getBankdetails().setBankname(ifscresponse.getData().getBANK());
					req.getMerchant().getBankdetails().setMicrcode(ifscresponse.getData().getMICRCODE());
					Bankaddress bankaddress=new Bankaddress();
					bankaddress.setAddress(ifscresponse.getData().getADDRESS());
					bankaddress.setBranch(ifscresponse.getData().getBRANCH());
					bankaddress.setCity(ifscresponse.getData().getCITY());
					bankaddress.setDistrict(ifscresponse.getData().getDISTRICT());
					bankaddress.setState(ifscresponse.getData().getSTATE());
					req.getMerchant().getBankdetails().setBankaddress(bankaddress);
				}
			String errmsg=ifscresponse.getMessage()+" for IFSC:- "+req.getMerchant().getBankdetails().getIFSC();
			return (getmapper.GetMerchantResponseMapper(req,ifscresponse.getStatus(), ifscresponse.getStatus().equalsIgnoreCase("SUCCESS") ? "200":"404",errmsg,""));
		}
		else
			return (getmapper.GetMerchantResponseMapper(req,"FAILED","404","IFSC Not entered",""));
			
	}


}
