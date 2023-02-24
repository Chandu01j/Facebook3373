package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;

public class TestVerifySignUpPageLink {
	
	public static void main(String[] args) throws InterruptedException {
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driverTest);
		loginOrSignUpPage.clickonCreatNewAccountButton();
		
		SignUpPage signUpPage = new SignUpPage(driverTest);
		signUpPage.clickonTermsLink();
		String url =driverTest.getCurrentUrl();
		System.out.println(url);
		if(url.equals("https://www.facebook.com/"))
		{
			
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
        }
		signUpPage.clickonCookiesPolicy();
		String url1 =driverTest.getCurrentUrl();
		System.out.println(url);
		if(url1.equals("https://www.facebook.com/"))
		{
			
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
}