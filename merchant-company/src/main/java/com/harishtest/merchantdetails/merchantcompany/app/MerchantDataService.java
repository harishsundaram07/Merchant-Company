package com.harishtest.merchantdetails.merchantcompany.app;

import org.springframework.http.ResponseEntity;

import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;

public interface MerchantDataService {
	
	public ResponseEntity<MerchantResponse> GetmerchantbyId(MerchantRequest details);
	public ResponseEntity<MerchantResponse> Addmerchant(MerchantRequest details);
	public ResponseEntity<MerchantResponseAll> GetAllMerchantByPhone(String phone);
	

}
