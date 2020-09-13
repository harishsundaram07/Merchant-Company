package com.harishtest.merchantdetails.merchantcompany.app;

import com.harishtest.merchantdetails.merchantcompany.datamodel.IFSCResponse;

public interface MerchantDataService {

	public IFSCResponse GetIFSCDetails(String ifsc);

}
