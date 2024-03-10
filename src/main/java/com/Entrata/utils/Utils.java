package com.Entrata.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utils {

	public void switchToWindow(WebDriver driver, int Window) {
		Set<String> WindowIDs = driver.getWindowHandles();
		List<String> WindowIDsList = new ArrayList<String>(WindowIDs);
		driver.switchTo().window(WindowIDsList.get(Window));

	}

	public void selectValueFromDropDownList(List<WebElement> element, String selectText) {

		for (WebElement options : element) {
			if (options.getText().trim().equals(selectText)) {
				options.click();
			}
		}
	}

	public void selectByVisibleText(WebElement element, String selectText) {
		Select sc = new Select(element);
		sc.selectByVisibleText(selectText);
	}

	public void chooseValueFromList(List<WebElement> element, String selectText) {

		for (WebElement options : element) {
			if (options.getText().trim().equals(selectText)) {
				options.click();
			}
		}
	}

	public void compareExpectedAndActualResult(String expectedResult, String actualResult, String successMessage,
			String failureMessage) {
		Assert.assertEquals(actualResult, expectedResult, failureMessage);
		System.out.println("Step Passed: " + successMessage);
	}

	public void compareExpectedAndActualResult(boolean expectedResult, boolean actualResult, String successMessage,
			String failureMessage) {
		Assert.assertEquals(actualResult, expectedResult, failureMessage);
		System.out.println("Step Passed: " + successMessage);
	}

	public void assertTrue(boolean condition, String successMessage, String failureMessage) {
		Assert.assertTrue(condition, failureMessage);
		System.out.println("Step Passed: " + successMessage);
	}

	public void assertFalse(boolean condition, String successMessage, String failureMessage) {
		Assert.assertFalse(condition, failureMessage);
		System.out.println("Step Passed: " + successMessage);
	}

	public boolean isElementPresent(WebElement element) {
		boolean vp = false;
		if (element != null) {
			try {
				if (element.isDisplayed()) {
					vp = true;
				}
			} catch (Exception e) {
				// do nothing as element is not found as expected here
			}
		}
		return vp;
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

}
