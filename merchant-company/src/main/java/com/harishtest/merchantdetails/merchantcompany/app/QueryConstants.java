package com.harishtest.merchantdetails.merchantcompany.app;

public interface QueryConstants {
	
	String InsertQuery="INSERT INTO Merchant.MERCHANTRECORDS (ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,CreateDateTime,BANKAccountNumber,CITY,STATE,COUNTRY,PHONETYPE,DOB,BANKNAME,IFSC) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String UpdateSEQID="UPDATE Merchant.sequence SET id=LAST_INSERT_ID(id+1)";
	String QuerySEQID="SELECT LAST_INSERT_ID()";
	String QuerybyId="SELECT ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,BANKAccountNumber,CITY,STATE,COUNTRY,PHONETYPE,DOB,BANKNAME,IFSC FROM MERCHANT.MERCHANTRECORDS WHERE MerchantID=?";
	String QueryAllbyphone="SELECT ACCHOLDERNAME,MerchantID,LastName,FirstName,AddressLine1,AddressLine2,Phoneno,Pincode,EmailId,BANKAccountNumber,CITY,STATE,COUNTRY,PHONETYPE,DOB,BANKNAME,IFSC FROM MERCHANT.MERCHANTRECORDS WHERE  Phoneno=?";
	String Querybyphone="SELECT MerchantID,BANKAccountNumber FROM MERCHANT.MERCHANTRECORDS WHERE Phoneno=? AND BANKAccountNumber=? ";
}
