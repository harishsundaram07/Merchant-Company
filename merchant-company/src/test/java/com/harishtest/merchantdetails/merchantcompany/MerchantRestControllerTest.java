package com.harishtest.merchantdetails.merchantcompany;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.harishtest.merchantdetails.merchantcompany.app.AddMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.GetMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.MerchantDataService;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.TestObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MerchantRestControllerTest {

	
	@Mock
	MerchantDataService merchantdataservice;
	@Autowired
	TestObjectMapper testmapper;
	@InjectMocks
	MerchantRestController service;
	
	private static final String mid="20201026";
	private static final String phoneno="9326715657";


	@Test
	final void testGetmerchantbyId()  {
		
		 MockHttpServletRequest request = new MockHttpServletRequest();
	      RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	      ResponseEntity<MerchantResponse> responsen=new ResponseEntity<MerchantResponse>(testmapper.Response(mid, "SUCCESS"),HttpStatus.OK);
	      when(merchantdataservice.GetmerchantbyId(testmapper.Request(mid))).thenReturn(responsen);
	      ResponseEntity<MerchantResponse> responsentity=service.GetmerchantbyId(testmapper.Request(mid));
	      assertEquals(200,responsentity.getStatusCodeValue());
	      
		
	}

	@Test
	final void testAddmerchant() {
		MockHttpServletRequest request = new MockHttpServletRequest();
	      RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	      ResponseEntity<MerchantResponse> responsen=new ResponseEntity<MerchantResponse>(testmapper.Response(mid, "SUCCESS"),HttpStatus.OK);
	      when(merchantdataservice.Addmerchant(testmapper.Request(mid))).thenReturn(responsen);
	      ResponseEntity<MerchantResponse> responsentity=service.Addmerchant(testmapper.Request(mid));
	      assertEquals(200,responsentity.getStatusCodeValue());
	      
	}
	
	@Test
	final void testGetAllbyphone() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
	      RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	      ResponseEntity<MerchantResponseAll> responsen=new ResponseEntity<MerchantResponseAll>(testmapper.ResponseAll(phoneno),HttpStatus.OK);
	      when(merchantdataservice.GetAllMerchantByPhone(phoneno)).thenReturn(responsen);
	      ResponseEntity<MerchantResponseAll> responsentity=service.GetAllbyphone(phoneno);
	      assertEquals(200,responsentity.getStatusCodeValue());
	      
		
	}
	

}
