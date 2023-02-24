package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.LoginOrSignUpPage;

public class TestSendMessage {
	
	
	
public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driverTest);
	//	loginOrSignUpPage.login();
		loginOrSignUpPage.sendEmailOrPhoneNo("chandrakantbharsawde7@gmail.com");
		loginOrSignUpPage.sendPassword("8177813031");
		loginOrSignUpPage.clickonLoginNutton();
		
		
		HomePage homePage = new HomePage(driverTest);
		Thread.sleep(3000);
		homePage.clickonReelsButton();
		homePage.clickonReelsPlayButton();
}
}