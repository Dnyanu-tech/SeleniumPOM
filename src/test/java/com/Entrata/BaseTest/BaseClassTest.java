package com.Entrata.BaseTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest {

	public static WebDriver driver;
	Properties prop;
	String userdirpath = System.getProperty("user.dir");

	@BeforeMethod
	public void initializeDriver() throws Exception {

		System.out.println("************************* Started Test *************************");

		if (driver == null) {
			FileInputStream ip = new FileInputStream(userdirpath + "\\src\\main\\resources\\_config.properties");
			prop = new Properties();
			prop.load(ip);
		}
		String url = prop.getProperty("URL");
		System.out.println("Application URL:- " + url);

		String browserName = prop.getProperty("browser");
		System.out.println("Browser:- " + browserName);
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
