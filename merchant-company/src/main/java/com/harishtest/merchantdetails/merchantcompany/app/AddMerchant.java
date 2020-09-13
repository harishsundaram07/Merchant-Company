package com.harishtest.merchantdetails.merchantcompany.app;

import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;

public interface AddMerchant {
	public MerchantResponse AddMerchantdata(MerchantRequest merchreq);
	public MerchantResponse ValidationCheck(MerchantRequest merchreq);
	
	


}
