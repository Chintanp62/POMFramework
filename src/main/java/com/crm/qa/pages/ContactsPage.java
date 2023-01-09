package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	Actions action;
	

	
	@FindBy(xpath ="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(name ="first_name")
	WebElement firstName;
	
	@FindBy(name ="last_name")
	WebElement lastName;
	
	@FindBy(name ="department")
	WebElement department;
	
	@FindBy(xpath ="//button[contains(text(),'Save')]")
	WebElement save;
	
	
	
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
public boolean verifyContactsLabel() {
	return contactsLabel.isDisplayed();
}

public void selectContactsByName(String name) throws InterruptedException {
	action= new Actions(driver);
	action.moveByOffset(15,15).perform();
	action.moveToElement(driver.findElement(By.xpath("//a[(text()='"+name+"')]/parent::td//preceding-sibling::td//input[@name='id']"))).click().perform();
	//action.moveToElement use when element is not able to clicled..
}

public void createNewContact( String ftName, String ltName, String  dtName) {

	firstName.sendKeys(ftName);
	lastName.sendKeys(ltName);
	department.sendKeys(dtName);
	save.click();
	
}
}

