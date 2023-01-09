package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//span[contains(text(),'Chintan Patel')]")
	WebElement userNameLabel;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createContact;



	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() throws IOException, InterruptedException {
		
		contactsLink.click();
		
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
		
		public void clickOnNewContactLink() throws InterruptedException {
			Actions action= new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			//Select select= new Select(driver.findElements(By.name("status")))
				createContact.click();
		}
}
	
	


