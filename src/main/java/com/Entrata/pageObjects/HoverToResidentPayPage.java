package com.Entrata.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Entrata.utils.Utils;

public class HoverToResidentPayPage {
	WebDriver driver;

	Utils ui = new Utils();

	@FindBy(xpath = "//div[text()='Products']")
	public WebElement Products;

	@FindBy(xpath = "//div[@class='nav-group']//a[text()='ResidentPay']")
	public WebElement ResidentPay;

	@FindBy(xpath = "//div[@class='button-holder']//a[text()='Schedule Demo']")
	public WebElement ScheduleDemo;

	@FindBy(xpath = "// button[text()='SCHEDULE DEMO']")
	public WebElement ScheduleDemoForm;

	public HoverToResidentPayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hoverToProducts(WebDriver driver) {
		ui.mouseHover(driver, Products);
	}

	public void clickOnTheResidentPay() {
		ResidentPay.click();
	}

	public boolean verifyScheduleDemoButton() {
		return ui.isElementPresent(ScheduleDemo);
	}

	public void clickOnTheScheduleDemo() {
		ScheduleDemo.click();
	}

	public boolean verifyScheduleDemoForm() {
		return ui.isElementPresent(ScheduleDemoForm);
	}

}
