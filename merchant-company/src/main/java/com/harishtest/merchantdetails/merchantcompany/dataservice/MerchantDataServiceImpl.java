package com.harishtest.merchantdetails.merchantcompany.dataservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.harishtest.merchantdetails.merchantcompany.app.MerchantDataService;
import com.harishtest.merchantdetails.merchantcompany.datamodel.IFSCResponse;

@Component
@ConfigurationProperties(prefix="ifscapi.enduser.connection")
public class MerchantDataServiceImpl implements MerchantDataService {
	
	private String ifscuri;
	
	public String getIfscuri() {
		return ifscuri;
	}

	public void setIfscuri(String ifscuri) {
		this.ifscuri = ifscuri;
	}

	@Override
	public IFSCResponse GetIFSCDetails(String ifsc) {
		String uri=ifscuri+ifsc;
	    RestTemplate restTemplate = new RestTemplate();
	    IFSCResponse result = restTemplate.getForObject(uri, IFSCResponse.class);      
	    System.out.println("IFSC RESPONSE RECEIVED");
		return result; 
	}
	
	

}
