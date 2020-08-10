package com.harishtest.merchantdetails.merchantcompany.app;

import java.util.List;

import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;

public interface UserRepository {
	
	public int InsertMerchant(MerchantRequest merchreq);
	public int SeqID();
	public MerchantRequest queryMerchantbyid(String mid);
	public List<Merchant> queryMerchantbyphone(Merchant merchant);
	public List<Merchant> queryAllbyphone(String phone);
	

}
