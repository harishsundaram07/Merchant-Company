package com.harishtest.merchantdetails.merchantcompany.datamapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.harishtest.merchantdetails.merchantcompany.datamodel.Errors;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Infos;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;
import com.harishtest.merchantdetails.merchantcompany.datamodel.ResponseDetails;

@Component
public class MerchantMapper {

	public MerchantResponse GetMerchantResponseMapper(MerchantRequest merchreq, String status, String errorcode, String errormsg, String stacktrace) {
		
		ResponseDetails response=new ResponseDetails();
		MerchantResponse merchresponse=new MerchantResponse();
		merchresponse.setMerchant(merchreq.getMerchant());
		if(status.equalsIgnoreCase("FAILED")) 
		{
			Errors error=new Errors();
			error.setErrorcode(errorcode);
			error.setErrormessage(errormsg);
			if(!stacktrace.isEmpty())
			error.setStacktrace(stacktrace);
			response.setError(error);
		}
		else
		{
			Infos info=new Infos();
			info.setCode(errorcode);
			info.setMsg(errormsg);
			response.setInfo(info);;
		}
		response.setStatus(status.toUpperCase());
		merchresponse.setResponsedetails(response);
		
		return merchresponse;
	}

	public MerchantResponseAll GetAllMapper(List<Merchant> merchlist, String status, String  code, String msg,String stacktrace) {
		
		ResponseDetails response=new ResponseDetails();
		if(status.equalsIgnoreCase("FAILED")) 
		{
			Errors error=new Errors();
			error.setErrorcode(code);
			error.setErrormessage(msg);
			if(!stacktrace.isEmpty())
			error.setStacktrace(stacktrace);
			response.setError(error);
		}
		else
		{
			Infos info=new Infos();
			info.setCode(code);
			info.setMsg(msg);
			response.setInfo(info);;
		}
		response.setStatus(status.toUpperCase());
		MerchantResponseAll responseall=new MerchantResponseAll();
		responseall.setAllMerchant(merchlist);
		responseall.setResponsedetails(response);
		return responseall;
	}



	


}
