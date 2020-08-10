package com.harishtest.merchantdetails.merchantcompany.businessservice;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.harishtest.merchantdetails.merchantcompany.app.UserRepository;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.TestObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class GetMerchantImplTests {
	
	
	@Mock
	MerchantMapper getmapper;
	@Mock
	UserRepository userrepository;
	@InjectMocks
	GetMerchantImpl service;
	@Autowired
	TestObjectMapper mapperobject;
	private static final String mid="20201026";
	private static final String phoneno="9326715657";


	@Test
	final void testGetmerchantbyID() throws JsonParseException, JsonMappingException, IOException {
		when(userrepository.queryMerchantbyid(mid)).thenReturn(mapperobject.Request(mid));
		when(getmapper.GetMerchantResponseMapper(mapperobject.Request(mid), "Success","200","Merchant 20201026 found successfully.","")).thenReturn(mapperobject.Response(mid, "SUCCESS"));
		assertEquals(mapperobject.Response(mid, "Success"),service.GetmerchantbyID(mid));
	}

	@Test
	final void testGetMerchantByPhone()
	{
		List<Merchant> list=new ArrayList<Merchant>();
		list.add(mapperobject.Merchants(mid));
		list.add(mapperobject.Merchants(mid));
		when(userrepository.queryAllbyphone("+91"+phoneno)).thenReturn(list);
		when(getmapper.GetAllMapper(list, "SUCCESS", "200", "All merchants found successfully for phone number:- +91"+phoneno+" .", "")).thenReturn(mapperobject.ResponseAll(phoneno));
		assertEquals(mapperobject.ResponseAll(phoneno),service.GetMerchantByPhone(phoneno));
	
	}
}
