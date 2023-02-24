package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	
	
	// Variable : WebElement :Login Or Sign Up Page
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement emailOrPhoneNo ; 
	
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ; 

	@FindBy (xpath = "//button[@type='submit']")
	private WebElement loginButton ; 

	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPasswordLink ; 

	@FindBy (xpath = "//a[text()='Create new account']")
	private WebElement creatNewAccountButton ; 
	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	
	 public LoginOrSignUpPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Methods : Action on WebElement : Login Or Sign Up Page
	 
	  public void sendEmailOrPhoneNo(String user) {
		 emailOrPhoneNo.sendKeys(user);
	 }
	  
	  public void sendPassword(String pass) {
			 password.sendKeys(pass);
		 }
	  
	  public void clickonLoginNutton() {
		  loginButton.click();
		 }
	  
	  public void clickonForgotPasswordLink() {
		  forgotPasswordLink.click();
		 }
	  
	  public void clickonCreatNewAccountButton() {
		  creatNewAccountButton.click();
		 }
	  
	  public void login(String userpass) {
		  emailOrPhoneNo.sendKeys(userpass);
		  password.sendKeys(userpass);
		  loginButton.click();
		  
	  }
	 
}
		 
	 

