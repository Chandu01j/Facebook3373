package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.ForgotPasswordPage;
import pomClasses.LoginOrSignUpPage;

public class TestForgotPasswordPage {
	
public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driverTest);
		loginOrSignUpPage.clickonForgotPasswordLink();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverTest);
		forgotPasswordPage.sendEmailidOrPhoneNo();
		forgotPasswordPage.clickonCancelButton();
		driverTest.close();

}
}