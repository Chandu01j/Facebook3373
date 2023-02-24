package testNgTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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


public class TestNgClass1 extends BrowserSetUp {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite 2");
	}
	
	WebDriver driver ;
	LoginOrSignUpPage loginOrSignUpPage ;
	SignUpPage signUpPage ;
	
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
		
	//	LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickonCreatNewAccountButton();
		
	}
	
	@Test
	public void VerifyTermsLink() {
	//	SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickonTermsLink();
		ArrayList<String> addr1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));//switch to child browser
		String acttitle =driver.getTitle();
		String exurltitle = "Facebook";
		Assert.assertEquals(acttitle, exurltitle);
		
		String acturl =driver.getCurrentUrl();
		String exurl = "https://www.facebook.com/legal/terms/update";
		Assert.assertEquals(acturl, exurl); 
	}
	
	@Test
	public void VerifyPrivacyPolicyLink() {
	//	SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickonPrivacyPolicy();
		ArrayList<String> addr1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));//switch to child browser
		try {
		String acttitle =driver.getTitle();
		String exurltitle = "Meta Privacy Policy – How Meta collects and uses user data | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
		Assert.assertEquals(acttitle, exurltitle);
		}
		catch(AssertionError e) { 
			String acttitle =driver.getTitle();
			String exurltitle = "Meta Privacy Policy – How Meta collects and uses user data";
			Assert.assertEquals(acttitle, exurltitle);
			
		}

		String acturl =driver.getCurrentUrl();
		String exurl = "https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
		Assert.assertEquals(acturl, exurl);
	}
	
	@Test
	public void VerifyCooliesPolicyLink() {
	//	SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.clickonCookiesPolicy();
		ArrayList<String> addr1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr1.get(1));//switch to child browser
		
//		String acttitle =driver.getTitle();
//		String exurltitle = "Meta Cookies Policy | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
//		Assert.assertEquals(acttitle, exurltitle);

		String acturl =driver.getCurrentUrl();
		String exurl = "https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
		Assert.assertEquals(acturl, exurl);
	}
	
	@AfterMethod
	public void BackPage() {
		driver.close();
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
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Before Suite 2");
	}
}
