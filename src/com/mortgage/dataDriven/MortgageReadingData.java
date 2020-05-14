package com.mortgage.dataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MortgageReadingData {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Xls_Reader reader = new Xls_Reader("/Users/omaidmomand/Desktop/ExeclData/ExcelConfig.xlsx");
		int rowCount = reader.getRowCount("Mortgage");
		    for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String homeValue = reader.getCellData("Mortgage", "Home_Value", rowNum);
			System.out.println(homeValue);
			String downPayment = reader.getCellData("Mortgage", "Down_Payment", rowNum);
			System.out.println(downPayment);
			String loanAmount = reader.getCellData("Mortgage", "Loan_Amount", rowNum);
			System.out.println(loanAmount);
			String intersetRate = reader.getCellData("Mortgage", "Loan_Amount", rowNum);
			System.out.println(intersetRate);
			String loanTerm = reader.getCellData("Mortgage", "Long_Term", rowNum);
			System.out.println(loanTerm);
			String Date = reader.getCellData("Mortgage", "Start_Date", rowNum);
			System.out.println(Date);
			String startYear = reader.getCellData("Mortgage", "Start_Year", rowNum);
			System.out.println(startYear);
			String propertyTax = reader.getCellData("Mortgage", "Property_Tax", rowNum);
			System.out.println(propertyTax);
			String pmi = reader.getCellData("Mortgage", "PMI", rowNum);
			System.out.println(pmi);
			String hoi = reader.getCellData("Mortgage", "Home_Insurance", rowNum);
			System.out.println(hoi);
			String hoa = reader.getCellData("Mortgage", "Monthly_HOA", rowNum);
			System.out.println(hoa);
			String loanType = reader.getCellData("Mortgage", "Loan_Type", rowNum);
			System.out.println(loanType);
			String buyRefi = reader.getCellData("Mortgage", "Home_Value", rowNum);
			System.out.println(buyRefi);
			String creditRating = reader.getCellData("Mortgage", "Credit_Rating", rowNum);
			System.out.println(creditRating);
		
			System.setProperty("webdriver.chrome.driver",
					"/Users/omaidmomand/eclipse-workspace/AutomationFrameWork/folder/chromedriver");
			driver = new ChromeDriver();
			driver.get("https://www.mortgagecalculator.org/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("homeval")).clear();
			driver.findElement(By.id("homeval")).sendKeys(homeValue);
			driver.findElement(By.id("downpayment")).clear();
			driver.findElement(By.id("downpayment")).sendKeys(downPayment);
			driver.findElement(By.id("loanamt")).clear();
			driver.findElement(By.id("loanamt")).sendKeys(loanAmount);
			driver.findElement(By.id("intrstsrate")).clear();
			driver.findElement(By.id("intrstsrate")).sendKeys(intersetRate);
			driver.findElement(By.id("loanterm")).clear();
			driver.findElement(By.id("loanterm")).sendKeys(loanTerm);
			Select startDate = new Select(driver.findElement(By.name("param[start_month]")));
			startDate.selectByVisibleText(Date);
			driver.findElement(By.id("start_year")).clear();
			driver.findElement(By.id("start_year")).sendKeys(startYear);
			driver.findElement(By.id("pptytax")).clear();
		    driver.findElement(By.id("pptytax")).sendKeys(propertyTax);
		    driver.findElement(By.id("pmi")).clear();
			driver.findElement(By.id("pmi")).sendKeys(pmi);
			driver.findElement(By.id("hoi")).clear();
			driver.findElement(By.id("hoi")).sendKeys(hoi);
			driver.findElement(By.id("hoa")).clear();
		    driver.findElement(By.id("hoa")).sendKeys(hoa);
		    Thread.sleep(2000);
			Select loan= new Select(driver.findElement(By.name("param[milserve]")));
			loan.selectByVisibleText(loanType);
			Select buyOrRefi = new Select(driver.findElement(By.name("param[refiorbuy]")));
			buyOrRefi.selectByVisibleText(buyRefi);
			Thread.sleep(2000);
			Select credit = new Select(driver.findElement(By.id("credit_rating")));
			credit.selectByVisibleText(creditRating);
			driver.findElement(By.xpath("//input[@name='cal']")).click();
			driver.close();
		    }
		
		    
		}
	
	    
	   } 




