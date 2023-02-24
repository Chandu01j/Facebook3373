package testNgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgClass {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite 1");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test 1");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");

     }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		
	}
	
	@Test
	public void testA() {
		System.out.println("Test A");
		
	}
	
	@Test
	public void testB() {
		System.out.println("Test B");
	}
	
	@Test
	public void testC() {
		System.out.println("Test C");
	}
	
	@Test
	public void testD() {
		System.out.println("Test D");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test 1");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Before Suite 1");
	}
	
}