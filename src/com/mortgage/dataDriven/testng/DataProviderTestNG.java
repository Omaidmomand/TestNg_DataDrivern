package com.mortgage.dataDriven.testng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {

	static WebDriver driver;
	

	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/omaidmomand/eclipse-workspace/AutomationFrameWork/folder/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.mortgagecalculator.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData= TestUtility.getDataFromExcel();
		return testData.iterator();
		
}
	@Test(dataProvider="getTestData")
	public void mortgageCalculator(String homeValue, String downPayment, String loanAmount, String intersetRate, String loanTerm, 
	String Date, String startYear, String propertyTax, String pmi, String hoi, String hoa, String loanType, String buyRefi, String creditRating) {
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
		Select loan = new Select(driver.findElement(By.name("param[milserve]")));
		loan.selectByVisibleText(loanType);
		Select buyOrRefi = new Select(driver.findElement(By.name("param[refiorbuy]")));
		buyOrRefi.selectByVisibleText(buyRefi);
		Select credit = new Select(driver.findElement(By.id("credit_rating")));
		credit.selectByVisibleText(creditRating);
		driver.findElement(By.xpath("//input[@name='cal']")).click();
	
        //reader.addColumn("Mortgage", "Approval");
		
	
	}

	@AfterMethod
	public void closing() {
		driver.quit();
	}
}