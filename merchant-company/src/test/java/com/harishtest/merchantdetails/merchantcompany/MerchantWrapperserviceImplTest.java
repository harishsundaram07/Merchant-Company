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
import org.springframework.http.ResponseEntity;

import com.harishtest.merchantdetails.merchantcompany.app.AddMerchant;
import com.harishtest.merchantdetails.merchantcompany.app.GetMerchant;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.TestObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponse;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantResponseAll;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MerchantWrapperserviceImplTest {
	
	@Mock
	GetMerchant merchantservice;
	@Autowired
	MerchantMapper getmapper;
	@Mock
	AddMerchant addmerchant;
	@InjectMocks
	MerchantWrapperserviceImpl service;
	@Autowired
	TestObjectMapper testmapper;
	
	private static final String mid="20201026";
	private static final String phoneno="9326715657";

	@Test
	final void testGetmerchantbyId() {
		when(merchantservice.GetmerchantbyID(mid)).thenReturn(testmapper.Response(mid, "SUCCESS"));
		 ResponseEntity<MerchantResponse> responsentity=service.GetmerchantbyId(testmapper.Request(mid));
	      assertEquals(200,responsentity.getStatusCodeValue());
	}

	@Test
	final void testAddmerchant() {
		when(addmerchant.AddMerchantdata(testmapper.Request(mid))).thenReturn(testmapper.Response(mid, "SUCCESS"));
		 ResponseEntity<MerchantResponse> responsentity=service.Addmerchant(testmapper.Request(mid));
		 assertEquals(200,responsentity.getStatusCodeValue());
	}
	
	@Test
	final void testGetAllMerchantByPhone() {
		
		when(merchantservice.GetMerchantByPhone(phoneno)).thenReturn(testmapper.ResponseAll(phoneno));
		ResponseEntity<MerchantResponseAll> responsentity=service.GetAllMerchantByPhone(phoneno);
		assertEquals(200,responsentity.getStatusCodeValue());
		
	}
}
