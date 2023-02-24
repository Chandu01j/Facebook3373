package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	

	// Variable : WebElement :Forgot Password Page
	
	@FindBy (xpath = "//div[@class='_9nq2 marginBottom16px']")
	private WebElement forgottext ; 
	
	
	@FindBy (xpath = "//input[@id='identify_email']")
	private WebElement emailidOrPhoneNo ; 

	@FindBy (xpath = "//button[@id='did_submit']")
	private WebElement searchButton ; 

	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancelButton ; 

	// Constructor : Initialization of WebElement : Forgot Password Page
	
		 public ForgotPasswordPage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
		 }
		 
		 //Methods : Action on WebElement : Forgot Password Page 
		 
      public void clickonForgottext() {
			  forgottext.click();
			 }
			  
			  public void sendEmailidOrPhoneNo() {
				  emailidOrPhoneNo.sendKeys("cbharsawde77@gmail.com");
				 }
			  
			  public void clickonsearchButton() {
				  searchButton.click();
				 }
			  
			  public void clickonCancelButton() {
				  cancelButton.click();
				 }
	

}
