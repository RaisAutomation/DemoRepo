package com.heroku.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseUtils {

	public static WebDriver driver;
	public static Properties prop;

	public BaseUtils() {
		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\heroku\\config\\config.properties");
			prop.load(ip);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void initialize() throws Exception {

		String DriverPath = prop.getProperty("DriverPath");
		switch (prop.getProperty("Browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.firefox.driver", DriverPath);
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", DriverPath);
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Invalid Browser Type In Property File");
			throw new Exception("Invalid Browser Type In Property File");

		}

		switch (prop.getProperty("WindowState").toLowerCase()) {

		case "maximized":
			driver.manage().window().maximize();
			break;

		case "minimized":
			/**
			 * Default is minimized
			 */
			break;
		default:
			System.out.println("Invalid Window Mode in property File");
			throw new Exception("Invalid Window Mode in property File");

		}

		long pageLoadTimeout = Long.parseLong(prop.getProperty("PageLoadTimeout"));
		long implicitTimeout = Long.parseLong(prop.getProperty("ImplicitTimeout"));
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
//		driver.get(prop.getProperty("URL"));

	}

}
