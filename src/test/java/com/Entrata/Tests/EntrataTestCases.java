package com.Entrata.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Entrata.BaseTest.BaseClassTest;
import com.Entrata.pageObjects.BaseCampPage;
import com.Entrata.pageObjects.ContactUsPage;
import com.Entrata.pageObjects.HoverToResidentPayPage;
import com.Entrata.pageObjects.LoginPage;
import com.Entrata.utils.Utils;

public class EntrataTestCases extends BaseClassTest {
	LoginPage login;
	HoverToResidentPayPage hover;
	BaseCampPage baseCamp;
	ContactUsPage contact;
	Utils ui;

	@BeforeMethod
	public void setUp() {
		login = new LoginPage(driver);
		hover = new HoverToResidentPayPage(driver);
		baseCamp = new BaseCampPage(driver);
		contact = new ContactUsPage(driver);
		ui = new Utils();

	}

	@AfterMethod
	public void terminateDriver() {
		driver.quit();
		System.out.println("************************* Ended Test *************************");

	}

	@Test(priority = 1)
	public void InvalidLoginPropertyManager() {

		login.clickOnTheAcceptCookies();
		login.clickOnTheSignInButton();

		login.clickOnThePropertyManagerLoginButton();

		ui.assertTrue(login.verifySignEntrataPage(), "Sign in to Entrata Page Navigated Successfully",
				"Sign in t`o Entrata Page Not Navigated Successfully");

		login.enterUsername("PropertyManager");
		login.enterPassword("123");
		login.clickOnTheLoginButton();

		ui.assertTrue(login.VerifyLoginError(), "The username and password provided are Not valid.",
				"The username and password provided are valid");
	}

	@Test(priority = 2)
	public void HoverToResidentPay() {

		login.clickOnTheAcceptCookies();
		hover.hoverToProducts(driver);
		hover.clickOnTheResidentPay();

		ui.assertTrue(hover.verifyScheduleDemoButton(), "hover To Resident Pay Successfully.",
				"hover To Resident Pay Successfully.");

		hover.clickOnTheScheduleDemo();

		ui.assertTrue(hover.verifyScheduleDemoForm(), "Schedule a demo Registeration Form Displayed Successfully.",
				"Schedule a demo Registeration Form Not Displayed Successfully.");
	}

	@Test(priority = 3)
	public void BaseCampRegistration() {

		login.clickOnTheAcceptCookies();
		baseCamp.navigateToBaseCampManu();
		ui.switchToWindow(driver, 1);

		ui.assertTrue(baseCamp.verifyBaseCampNavigated(), "Base Camp Register Now Page Navigated Successfully.",
				"Base Camp Register Now Page Not Navigated Successfully.");

		baseCamp.clickOnTheRegisterNow();
		baseCamp.clickOnTheConfirmRegister();
		ui.assertTrue(baseCamp.verifyBaseCampForm(), "Base Camp Registeration Form Displayed Successfully.",
				"Base Camp Registeration Form Not Displayed Successfully.");
		driver.close();
		ui.switchToWindow(driver, 0);
	}

	@Test(priority = 4)
	public void ContactUSForm() {

		login.clickOnTheAcceptCookies();
		login.clickOnTheSignInButton();
		login.navigateToResidentLogin();
		login.clickOnTheViewWebsite();

		ui.assertTrue(contact.verifylinkContactUsPage(), "Welcome to Resident Portal Page Displayed",
				"Welcome to Resident Portal Page Not Displayed");

		contact.navigateToContactUsForm();
		contact.enterFullName("ABC DCF");

		contact.enterEmail("email@gmail.com");
		contact.enterPropertyName("CBD");
		contact.enterPropertyUrl("WWw.CBD.com");
		contact.selectCategory("Payments");
		contact.enterMessage("Text");

		ui.assertTrue(contact.verifySubmitButton(), "Contact Us Form Displayed", "Contact Us Form Not Displayed");
	}

}
