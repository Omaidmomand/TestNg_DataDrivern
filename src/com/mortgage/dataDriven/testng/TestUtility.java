package com.mortgage.dataDriven.testng;

import java.util.ArrayList;

import com.mortgage.dataDriven.Xls_Reader;

public class TestUtility {
static Xls_Reader reader;


public static ArrayList<Object[]> getDataFromExcel(){
	ArrayList<Object[]> myData =new ArrayList<Object[]>();
	
	
		
	try {
	reader = new Xls_Reader("/Users/omaidmomand/Desktop/ExeclData/ExcelConfig.xlsx");
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	

for (int rowNum = 2; rowNum <= reader.getRowCount("Mortgage"); rowNum++) {
	String homeValue = reader.getCellData("Mortgage", "Home_Value", rowNum);
	String downPayment = reader.getCellData("Mortgage", "Down_Payment", rowNum);
	String loanAmount = reader.getCellData("Mortgage", "Loan_Amount", rowNum);
	String intersetRate = reader.getCellData("Mortgage", "Loan_Amount", rowNum);
	String loanTerm = reader.getCellData("Mortgage", "Long_Term", rowNum);
	String Date = reader.getCellData("Mortgage", "Start_Date", rowNum);
	String startYear = reader.getCellData("Mortgage", "Start_Year", rowNum);
	String propertyTax = reader.getCellData("Mortgage", "Property_Tax", rowNum);
	String pmi = reader.getCellData("Mortgage", "PMI", rowNum);
	String hoi = reader.getCellData("Mortgage", "Home_Insurance", rowNum);
	String hoa = reader.getCellData("Mortgage", "Monthly_HOA", rowNum);
	String loanType = reader.getCellData("Mortgage", "Loan_Type", rowNum);
	String buyRefi = reader.getCellData("Mortgage", "Home_Value", rowNum);
	String creditRating = reader.getCellData("Mortgage", "Credit_Rating", rowNum);
	
	Object ob[]= {homeValue, downPayment,loanAmount,intersetRate,loanTerm, Date, startYear,propertyTax, pmi, 
			hoi,  hoa, loanType,  buyRefi, creditRating};
       myData.add(ob);
       

}
return myData;
}
}