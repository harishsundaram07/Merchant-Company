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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.harishtest.merchantdetails.merchantcompany.app.UserRepository;
import com.harishtest.merchantdetails.merchantcompany.datamapper.MerchantMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.TestObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AddMerchantdataImplTest {
	@Mock
	UserRepository userrepository;
	@Mock
	MerchantMapper mapper;
	@InjectMocks
	AddMerchantdataImpl service;
	@Autowired
	TestObjectMapper testmapper;
	private static final String mid="20201026";


	@Test
	final void testAddMerchantdata() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		when(service.ValidationCheck(testmapper.Request(mid))).thenReturn(testmapper.Response(mid, "SUCCESS"));
		when(userrepository.SeqID()).thenReturn(1026);
		when(userrepository.InsertMerchant(testmapper.Request(mid))).thenReturn(1);
		when(mapper.GetMerchantResponseMapper(testmapper.Request(mid), "SUCCESS", "200", "Merchant 20201026  added successfully.", "")).thenReturn(testmapper.Response(mid, "SUCCESS"));
		assertEquals(testmapper.Response(mid, "SUCCESS"),service.AddMerchantdata(testmapper.Request(mid)));
	}

	@Test
	final void testValidationCheck() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		List<Merchant> list=new ArrayList<Merchant>();
		//list.add(testmapper.Merchants(mid));
		when(userrepository.queryMerchantbyphone(testmapper.Merchants(mid))).thenReturn(list);
		when(mapper.GetMerchantResponseMapper(testmapper.Request(mid), "Success", "VALIDATION Success","valid data combination.","")).thenReturn(testmapper.Response(mid, "SUCCESS"));
		assertEquals(testmapper.Response(mid, "SUCCESS"), service.ValidationCheck(testmapper.Request(mid)));
	}


}
