package testNgTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.BrowserSetUp;
import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;
import utils.Utility;

public class TestNgclass_3 extends BrowserSetUp {
	
	
	
	
	WebDriver driver ;
	LoginOrSignUpPage loginOrSignUpPage ;
	SignUpPage signUpPage ;
	
	private String testID ;
	
	@Parameters ("browser")
	@BeforeTest
	public void LauchBrowser(String browserName) {
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();	
		}
		
		if(browserName.equals("Edge"))
		{
			 driver = openEdgeBrowser();
		}
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void ctreatePOMObjects() {
		loginOrSignUpPage =new LoginOrSignUpPage(driver);
		 signUpPage = new SignUpPage(driver);
		
	}
 
	@BeforeMethod
	public void goToSignUpForm() {
		
		driver.get("https://www.facebook.com/");
	}
   @Test
   public void VerifyLogin() throws Exception {
	   testID = "TC101";
	   
	   String data =   Utility.fetchDataFromExcelSheet("TestData", 1, 0);
	    loginOrSignUpPage.sendEmailOrPhoneNo(data);
	    
	     data =   Utility.fetchDataFromExcelSheet("TestData", 1, 1);
		loginOrSignUpPage.sendPassword(data);
		loginOrSignUpPage.clickonLoginNutton();
		}
   @Test
   public void VerifyCreateNewAccount() throws InterruptedException, IOException {
	   
	   testID = "TC102";
	   loginOrSignUpPage.clickonCreatNewAccountButton();
		
	//	SignUpPage signUpPage = new SignUpPage(driver);
	    String data =   Utility.fetchDataFromExcelSheet("TestData", 1, 5);
		signUpPage.sendFirstName(data);
		data =   Utility.fetchDataFromExcelSheet("TestData", 1, 6);
		signUpPage.sendLastName(data); 
	//	data =   Utility.fetchDataFromExcelSheet("TestData", 1, 3);
	//    signUpPage.sendMobileNoOrEmailID(data);
		data =   Utility.fetchDataFromExcelSheet("TestData", 1, 1);
		signUpPage.sendPassword(data);
		signUpPage.selectDate();
		Thread.sleep(5000);
		signUpPage.selectMonth();
		Thread.sleep(5000);
		signUpPage.selectYear();
		signUpPage.clickonSex();
	//	signUpPage.clickonSignUpButton();
   }
   
   
   
   @AfterMethod
	public void BackPage(ITestResult result) throws IOException {
	   
	   if(ITestResult.FAILURE == result.getStatus())
	   {
		   Utility.captureScreenshot(driver, testID);
	   }
		
		ArrayList<String> addr1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr1.get(0));//switch to child browser
	}
	
	@AfterClass
	public void clearPOMObjects() {
		loginOrSignUpPage = null ;
		signUpPage = null ;
	}
	
	@AfterTest 
	public void closedbrowser() {
		driver.quit();
		driver = null ;
		
		System.gc();
	}
	
   
}
