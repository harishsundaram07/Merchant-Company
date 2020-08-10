package com.harishtest.merchantdetails.merchantcompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harishtest.merchantdetails.merchantcompany.app.MerchantDataService;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;

@RestController
public class MerchantRestController {
	
	@Autowired
	MerchantDataService merchantdataservice;
	
	

	
	
	@PostMapping("/getmerchantid")
	public ResponseEntity<MerchantResponse> GetmerchantbyId(@RequestBody MerchantRequest details)
	{	
		return (merchantdataservice.GetmerchantbyId(details));
	}
	
	
	@PostMapping("/addmerchant")
	public ResponseEntity<MerchantResponse> Addmerchant(@RequestBody MerchantRequest details)
	{
		return (merchantdataservice.Addmerchant(details));
	}
	
	@GetMapping("/getmerchantbyphone/{phone}")
	public ResponseEntity<MerchantResponseAll> GetAllbyphone(@PathVariable("phone") String phone)
	{
		return(merchantdataservice.GetAllMerchantByPhone(phone));
	}	

}
