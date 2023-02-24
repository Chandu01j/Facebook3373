package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.ForgotPasswordPage;
import pomClasses.LoginOrSignUpPage;


public class TestLoginPage {
	
	
	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.facebook.com/");
		
	//	LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driverTest);
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driverTest);
	
		loginOrSignUpPage.sendEmailOrPhoneNo("chandrakantbharsawde7@gmail.com");
		loginOrSignUpPage.sendPassword("8177813031");
		loginOrSignUpPage.clickonLoginNutton();
		
		// or
	//	loginOrSignUpPage.login()
		
		
//	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverTest);
	
//	forgotPasswordPage.sendEmailidOrPhoneNo();
//    forgotPasswordPage.clickonsearchButton();
//		
//		
		
		
		
		
		
		
	}

}
