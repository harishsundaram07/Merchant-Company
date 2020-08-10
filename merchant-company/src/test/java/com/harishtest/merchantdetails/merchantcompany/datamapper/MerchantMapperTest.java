package com.harishtest.merchantdetails.merchantcompany.datamapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MerchantMapperTest {
	
	@Autowired
	TestObjectMapper testmapper;
	@InjectMocks
	MerchantMapper service;
	private static final String mid="20201026";
	
	@Test
	final void testGetMerchantResponseMapper() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		testmapper.MerchantResponseJson(service.GetMerchantResponseMapper(testmapper.Request(mid), "SUCCESS", "200", "OK", ""));
	}
	@Test
	final void testGetAllMapper() throws IOException
	{
		List<Merchant> list=new ArrayList<Merchant>();
		list.add(testmapper.Merchants(mid));
		list.add(testmapper.Merchants(mid));
		testmapper.ResponseAllJson(service.GetAllMapper(list, "SUCCESS", "200", "OK", ""));
	}
	

}
