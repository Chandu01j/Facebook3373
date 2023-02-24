package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;

public class TestSignUpPage {
	
public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage =new LoginOrSignUpPage(driverTest);
		loginOrSignUpPage.clickonCreatNewAccountButton();
		
		SignUpPage signUpPage = new SignUpPage(driverTest);
		signUpPage.sendFirstName("chandrakant");
		signUpPage.sendLastName("Bharsawde");
		signUpPage.sendMobileNoOrEmailID("8177813031");
		signUpPage.sendPassword("Chandu@123");
		signUpPage.selectDate();
		Thread.sleep(5000);
		signUpPage.selectMonth();
		Thread.sleep(5000);
		signUpPage.selectYear();
		signUpPage.clickonSex();
		signUpPage.clickonSignUpButton();
		
}
}