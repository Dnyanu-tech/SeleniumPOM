package com.Entrata.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Entrata.utils.Utils;

public class LoginPage {
	WebDriver driver;
	Utils ui = new Utils();

	@FindBy(xpath = "//button[text()='Accept Cookies']")
	public WebElement acceptCookiesButton;

	@FindBy(xpath = "(//a[text()='Sign In'])[1]")
	public WebElement signInButton;

	// Property Manager Login

	@FindBy(xpath = "//input[@id='entrata-username']")
	public WebElement txtUsername;

	@FindBy(xpath = "//input[@id='entrata-password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement btnSingIn;

	@FindBy(xpath = "//a[text()='Property Manager Login']")
	public WebElement btnPropertyManagerLogin;

	@FindBy(xpath = "//div[@class='login-errors']")
	public WebElement labelLoginerrors;

	// Resident Login

	@FindBy(xpath = "//a[@title='Resident Portal Login Button']")
	public WebElement ResidentLogin;

	@FindBy(xpath = "//div[text()='View the Website']")
	public WebElement ViewWebsite;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTheAcceptCookies() {

		if (ui.isElementPresent(acceptCookiesButton)) {
			acceptCookiesButton.click();
		} else {
			System.out.println("accept Cookies Not found");
		}

	}

	public void clickOnThePropertyManagerLoginButton() {
		btnPropertyManagerLogin.click();
	}

	public void clickOnTheSignInButton() {
		signInButton.click();
	}

	public boolean verifySignEntrataPage() {

		boolean vp = false;
		try {
			vp = txtUsername.isDisplayed();
		} catch (Exception e) {
		}
		return vp;

	}

	public void enterUsername(String Username) {
		txtUsername.sendKeys(Username);
	}

	public void enterPassword(String Password) {
		txtPassword.sendKeys(Password);
	}

	public void clickOnTheLoginButton() {
		btnSingIn.click();
	}

	public boolean VerifyLoginError() {

		boolean vp = false;
		try {
			vp = labelLoginerrors.isDisplayed();
		} catch (Exception e) {
		}
		return vp;

	}

	public void navigateToResidentLogin() {
		ResidentLogin.click();
	}

	public void clickOnTheViewWebsite() {
		ViewWebsite.click();
	}

}
