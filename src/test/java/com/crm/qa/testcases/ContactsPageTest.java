package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName= "Sheet1";

	public ContactsPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Initializations();
	loginPage= new LoginPage();
	testUtil= new TestUtil();
	contactsPage = new ContactsPage();
	homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage=homePage.clickOnContactsLink();
	Thread.sleep(4000);
		
	}
	
	
	
	  @Test(priority=1) public void verifyContactsPageLabel() throws
	  InterruptedException {
	  
	  Assert.assertTrue(contactsPage.verifyContactsLabel(),
	  "Contacts label is missing on the page");
	  
	  
	  }
	  
	  @Test(priority=2)
	  
	  public void selectContactsTest() throws InterruptedException {
	  
	  contactsPage.selectContactsByName("Chetan Pat");
	  
	  }
	  
	  @Test(priority=3)
	  
	  public void selectmultipleContactsTest() throws InterruptedException {
	  
	  contactsPage.selectContactsByName("Chetan Pat");
	  contactsPage.selectContactsByName("hardik patel");
	  
	  }
	 

	  @DataProvider
	  
	  public Object[][] getCRMTestData() {
		 Object data[][]= TestUtil.getTestData(sheetName);
		 return data;
	  }
	  
	@Test(priority=4, dataProvider="getCRMTestData")
	
	public void validateCreateNewContact(String firstname, String lastname, String department) throws IOException, InterruptedException {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact( firstname, lastname,department );
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
//a[contains(text(),'hardik patel')]//parent::td//preceding-sibling::td//input[@class='hidden']
