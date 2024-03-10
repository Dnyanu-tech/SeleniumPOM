package com.Entrata.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Entrata.utils.Utils;

public class BaseCampPage {
	WebDriver driver;

	Utils ui = new Utils();

	@FindBy(xpath = "//div[@class='header-nav-item']/a[text()='Base Camp']")
	public WebElement menuBaseCamp;

	@FindBy(xpath = "// *[@role='banner']//div[text()='Register Now']")
	public WebElement btnRegisterNow;

	@FindBy(xpath = "// button[@title='Yes'][@type='button']")
	public WebElement btnYes;

	@FindBy(xpath = "//*[text()='Personal Information']")
	public WebElement labelPersonalInformation;

	public BaseCampPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToBaseCampManu() {
		menuBaseCamp.click();
	}

	public boolean verifyBaseCampNavigated() {
		boolean vp = false;
		try {
			vp = btnRegisterNow.isDisplayed();
		} catch (Exception e) {
		}
		return vp;
	}

	public void clickOnTheRegisterNow() {
		btnRegisterNow.click();
	}

	public void clickOnTheConfirmRegister() {

		if (ui.isElementPresent(btnYes)) {
			btnYes.click();
		}

	}

	public boolean verifyBaseCampForm() {
		boolean vp = false;
		try {
			vp = labelPersonalInformation.isDisplayed();
		} catch (Exception e) {
		}
		return vp;
	}

}
