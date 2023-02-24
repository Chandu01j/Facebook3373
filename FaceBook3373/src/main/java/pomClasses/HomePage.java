package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	// Variable : WebElement :Login Or Sign Up Page
	
		@FindBy (xpath = "(//div[@aria-label='Facebook']//a)[2]")
		private WebElement videoButton ; 
		
		
		@FindBy (xpath = "(//div[contains(@class,'xds687c x1pi30')]//div)[17]")
		private WebElement messengerButton ; 

		@FindBy (xpath = "//input[@placeholder='Search Messenger']")
		private WebElement searchmessenger ; 
		
		@FindBy (xpath = "((//div[@class='x1n2onr6'])[15]//span)[2]")
		private WebElement sentmessageperson ; 


		@FindBy (xpath = "//div[@aria-label='Message']")
		private WebElement message ; 

		@FindBy (xpath = "((//div[@class='x78zum5 x1n2onr6 xh8yej3'])[1]//span)[2]")
		private WebElement reelsButton ; 
		
		@FindBy (xpath = "(((//div[@class='x78zum5 x1n2onr6 xh8yej3'])[1])//div)[22]")
		private WebElement reelsPlayButton ; 
		
		private WebDriver driver ;
		// Constructor : Initialization of WebElement : Login Or Sign Up Page
		
		 public HomePage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
			 this.driver = driver;
		 }
		 
		 //Methods : Action on WebElement : Login Or Sign Up Page
		 
		  public void clickvideoButton() {
			  videoButton.click();
		 }
		  
		  public void clickonMessengerButton() {
				 messengerButton.click();
			 }
		  
		  public void  sendSearchmessenger() {
			  searchmessenger.click();
			  searchmessenger.sendKeys("dinesh kadam");
			 }
	  
		  public void clickonSentmessageperson() {
			  sentmessageperson.click();
			 }
		  
		  public void sendMessage() {
			  message.click();
			  message.sendKeys("hiii");
			 }
		  
		  public void clickonReelsButton() {
			  reelsButton.click();
			 }
		  public void clickonReelsPlayButton() {
			  Actions act = new Actions(driver); 
			  act.moveToElement(reelsButton).moveToElement(reelsPlayButton).click().build().perform();
			 }
			  
		 

}
