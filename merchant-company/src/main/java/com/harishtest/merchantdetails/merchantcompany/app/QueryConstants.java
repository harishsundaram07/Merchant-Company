package com.harishtest.merchantdetails.merchantcompany.app;

public interface QueryConstants {
	
	String InsertQuery="INSERT INTO MERCHANT.MERCHANTRECORDS (ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,CreateDateTime,BankAccountNumber,City,State,Country,PHONETYPE,DOB,BankName,IFSC) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String UpdateSEQID="UPDATE MERCHANT.sequence SET id=LAST_INSERT_ID(id+1)";
	String QuerySEQID="SELECT LAST_INSERT_ID()";
	String QuerybyId="SELECT ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,BankAccountNumber,City,State,Country,PHONETYPE,DOB,BankName,IFSC FROM MERCHANT.MERCHANTRECORDS WHERE MerchantID=?";
	String QueryAllbyphone="SELECT ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,BankAccountNumber,City,State,Country,PHONETYPE,DOB,BankName,IFSC FROM MERCHANT.MERCHANTRECORDS WHERE  Phoneno=?";
	String Querybyphone="SELECT MerchantID,BankAccountNumber FROM MERCHANT.MERCHANTRECORDS WHERE Phoneno=? AND BankAccountNumber=? ";
}
