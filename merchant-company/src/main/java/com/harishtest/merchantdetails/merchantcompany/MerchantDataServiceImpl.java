package com.harishtest.merchantdetails.merchantcompany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.harishtest.merchantdetails.merchantcompany.app.AddMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.GetMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.MerchantDataService;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;


@Component
public class MerchantDataServiceImpl implements MerchantDataService {
	
	@Autowired
	GetMerchant merchantservice;
	@Autowired
	MerchantMapper getmapper;
	@Autowired
	AddMerchant addmerchant;

	@Override
	public ResponseEntity<MerchantResponse> GetmerchantbyId(MerchantRequest details) {
		try {
			MerchantResponse detailsresponse=merchantservice.GetmerchantbyID(details.getMerchant().getMerchantdetails().getMerchantid());
			 if(detailsresponse==null )
				 return new ResponseEntity<MerchantResponse> (HttpStatus.NOT_FOUND);
			 else
				 return new ResponseEntity<MerchantResponse> (detailsresponse,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<MerchantResponse> (getmapper.GetMerchantResponseMapper(details, "FAILED","INTERNAL SERVER ERROR", e.getMessage(), e.getLocalizedMessage()),HttpStatus.OK);

		}
	}

	@Override
	public ResponseEntity<MerchantResponse> Addmerchant(MerchantRequest details) {
		
		
		try {
			MerchantResponse detailsresponse=addmerchant.AddMerchantdata(details);
			 if(detailsresponse==null )
				 return new ResponseEntity<MerchantResponse> (HttpStatus.NOT_FOUND);
			 else
				 return new ResponseEntity<MerchantResponse> (detailsresponse,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<MerchantResponse> (getmapper.GetMerchantResponseMapper(details, "FAILED","INTERNAL SERVER ERROR", e.getMessage(), e.getLocalizedMessage()),HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<MerchantResponseAll> GetAllMerchantByPhone(String phone) {
		// TODO Auto-generated method stub

		try {
			MerchantResponseAll detailsresponse=merchantservice.GetMerchantByPhone(phone);
			 if(detailsresponse==null )
				 return new ResponseEntity<MerchantResponseAll> (HttpStatus.NOT_FOUND);
			 else
				 return new ResponseEntity<MerchantResponseAll> (detailsresponse,HttpStatus.OK);
		} catch (Exception e) {
			//e.printStackTrace();
			 List<Merchant> list=new ArrayList<Merchant>();
			return new ResponseEntity<MerchantResponseAll> (getmapper.GetAllMapper(list, "FAILED","INTERNAL-SERVER-ERROR","Get allmerchantfailed for phoneno.:- "+phone+ e.getMessage(), e.getLocalizedMessage()),HttpStatus.OK);
		}
	}

}
