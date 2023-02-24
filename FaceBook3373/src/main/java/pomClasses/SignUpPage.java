package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	

	// Variable : WebElement :Login Or Sign Up Page
	
	@FindBy (xpath = "//input[@name='firstname']")
	private WebElement firstName ; 
	
	
	@FindBy (xpath = "//input[@name='lastname']")
	private WebElement lastName ; 

	@FindBy (xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement mobileNoOrEmailID ; 

	@FindBy (xpath = "//input[@id='password_step_input']")
	private WebElement password ; 

	@FindBy (xpath = "//select[@id='day']")
	private WebElement dayOfBirth ; 
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement monthOfBirth ; 
	
	@FindBy (xpath = "//select[@id='year']")
	private WebElement yearOfbirth ; 
	
	@FindBy (xpath = "(//input[@name='sex'])[2]")
	private WebElement sex ;
	
	@FindBy (xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signUpButton ;
	
	@FindBy (xpath = "(//a[text()='Terms'])[2]")
	private WebElement termsLink ;
	
	@FindBy (xpath = "(//a[text()='Privacy Policy'])[2]")
	private WebElement privacyPolicy ;
	
	@FindBy (xpath = "//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy ;
	
	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	
	 public SignUpPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Methods : Action on WebElement : Login Or Sign Up Page
	 
	  public void sendFirstName(String firstN) {
		  firstName.sendKeys(firstN);
	 }
	  
	  public void sendLastName(String lastN) {
		  lastName.sendKeys(lastN);
		 }
	  
	  public void sendMobileNoOrEmailID(String mobileN) {
		  mobileNoOrEmailID.sendKeys(mobileN);
		 }
	  
	  public void sendPassword(String pass) {
		  password.sendKeys(pass);
		 }
	  
	  public void selectDate() {
		  Select s = new Select(dayOfBirth);
		  s.selectByValue("1");
		 }
	  
	  public void selectMonth() {
		  Select s = new Select(monthOfBirth);
		  s.selectByVisibleText("Jul");
		   }
	  
	  public void selectYear() {
		  Select s = new Select(yearOfbirth);
		  s.selectByVisibleText("1990");
		   }
	  
	  public void clickonSex() {
		  sex.click();
		 }
	  public void clickonSignUpButton() {
		  signUpButton.click();
		 }
	  
	  public void clickonTermsLink() {
		  termsLink.click();
		 }
	  
	  public void clickonPrivacyPolicy() {
		  privacyPolicy.click();
		 }
	  
	  public void clickonCookiesPolicy() {
		  cookiesPolicy.click();
		 }
	 

}
