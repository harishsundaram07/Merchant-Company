package com.harishtest.merchantdetails.merchantcompany.dbfunctions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.harishtest.merchantdetails.merchantcompany.datamapper.GetMerchantRowMapper;
import com.harishtest.merchantdetails.merchantcompany.datamapper.TestObjectMapper;
import com.harishtest.merchantdetails.merchantcompany.datamodel.Merchant;
import com.harishtest.merchantdetails.merchantcompany.datamodel.MerchantRequest;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class UserRepositoryImplTest {
	
	@Autowired
	 private  JdbcTemplate jdbctemplate;
	

	
	
	
	@Autowired
	TestObjectMapper testmapper;
	private static final String mid="20201026";
	private static final String phoneno="9326715657";
	
	@BeforeAll
	 void setUpBeforeClass() throws Exception {
		ScriptUtils.executeSqlScript(jdbctemplate.getDataSource().getConnection(), new ClassPathResource("scripts/create/createdb.sql"));
		ScriptUtils.executeSqlScript(jdbctemplate.getDataSource().getConnection(), new ClassPathResource("scripts/create/createtable.sql"));
		ScriptUtils.executeSqlScript(jdbctemplate.getDataSource().getConnection(), new ClassPathResource("scripts/create/insertrow.sql"));
		System.out.println("Executed Before");
	}

	@AfterAll
	 void tearDownAfterClass() throws Exception {
		ScriptUtils.executeSqlScript(jdbctemplate.getDataSource().getConnection(), new ClassPathResource("scripts/create/droptable.sql"));
		ScriptUtils.executeSqlScript(jdbctemplate.getDataSource().getConnection(), new ClassPathResource("scripts/create/dropschema.sql"));
		System.out.println("Executed After");
	}
	@Autowired
	private UserRepositoryImpl service;

	@Test
	final void testInsertMerchant() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

		int update=service.InsertMerchant(testmapper.Request("20201027"));
		assertEquals(1,update);
		System.out.println("Executed InsertMerchant");
		
	}

	@Test
	final void testQueryMerchantbyid() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		MerchantRequest merchant=service.queryMerchantbyid(mid);
		testmapper.MerchantReequestJson(merchant);
		System.out.println("Executed queryMerchantbyid");
	}


	@Test
	final void testQueryMerchantbyphone() throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		List<Merchant> list=new ArrayList<Merchant>();
		list=service.queryMerchantbyphone(testmapper.Merchants(mid));
		assertEquals(2,list.size());
		System.out.println("Executed QueryMerchantbyphone");
	}
	
	@Test
	final void testQueryAllbyphone()
	{
		List<Merchant> list=service.queryAllbyphone("+91"+phoneno);
		assertEquals(2,list.size());
		System.out.println("Executed queryAllbyphone");
		
	}
}
