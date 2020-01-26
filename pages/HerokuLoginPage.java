package com.heroku.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.heroku.utils.BaseUtils;

public class HerokuLoginPage extends BaseUtils {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(@type,\"submit\")]")
	WebElement loginButton;

	@FindBy(xpath = "//h2")
	WebElement header;

	@FindBy(xpath = "//div[@id=\"flash\"]")
	WebElement logInSuccessMsg;

	public HerokuLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHeader() {

		return header.getText();
	}

	public String ValidatePageTitle() {
		return driver.getTitle();
	}

	public boolean loginVerification(String userName, String pwd) {
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(username)).sendKeys(userName);
//		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginButton.click();
		return logInSuccessMsg.getText().contains("You logged into a secure area!");

	}

}
