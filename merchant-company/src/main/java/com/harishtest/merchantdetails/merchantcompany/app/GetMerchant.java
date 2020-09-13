package com.harishtest.merchantdetails.merchantcompany.app;

import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;

public interface GetMerchant {
	
	public MerchantResponse GetmerchantbyID(String mid);
	public MerchantResponseAll GetMerchantByPhone(String phone);
	public MerchantResponse GetIFSCDetails(MerchantRequest req);

}
