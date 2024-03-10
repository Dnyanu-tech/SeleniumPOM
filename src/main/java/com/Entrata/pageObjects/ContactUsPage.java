package com.Entrata.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Entrata.utils.Utils;

public class ContactUsPage {

	Utils ui = new Utils();

	@FindBy(xpath = "//div[@class='landing-nav four-content']//a[text()='Contact Us']")
	public WebElement linkContactUs;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement txtName;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement txtEmail;

	@FindBy(xpath = "//input[@id='property_name']")
	public WebElement txtPropertyName;

	@FindBy(xpath = "//input[@id='property_url']")
	public WebElement txtPropertyUrl;

	@FindBy(xpath = "//select[@class='contact-drop']")
	public WebElement ddlCategory;

	@FindBy(xpath = "//textarea[@id='message']")
	public WebElement txtMessage;

	@FindBy(xpath = "//button[@name='submit']")
	public WebElement btnSubmit;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean verifylinkContactUsPage() {
		boolean vp = false;
		try {
			vp = linkContactUs.isDisplayed();
		} catch (Exception e) {
		}
		return vp;
	}

	public void navigateToContactUsForm() {
		linkContactUs.click();
	}

	public void enterFullName(String FullName) {
		txtName.sendKeys(FullName);
	}

	public void enterEmail(String Email) {
		txtEmail.sendKeys(Email);
	}

	public void enterPropertyName(String PropertyName) {
		txtPropertyName.sendKeys(PropertyName);
	}

	public void enterPropertyUrl(String PropertyUrl) {
		txtPropertyUrl.sendKeys(PropertyUrl);
	}

	public void selectCategory(String Category) {
		ui.selectByVisibleText(ddlCategory, Category);
	}

	public void enterMessage(String Message) {
		txtMessage.sendKeys(Message);
	}

	public boolean verifySubmitButton() {
		boolean vp = false;
		try {
			vp = btnSubmit.isDisplayed();
		} catch (Exception e) {
		}
		return vp;

	}

}
