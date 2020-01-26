package com.heroku.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.heroku.utils.BaseUtils;

public class HerokuLoginPage extends BaseUtils {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(@type,\"submit\")]")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id=\"flash\"]")
	WebElement logInSuccessMsg;

	public HerokuLoginPage() throws Exception {
		PageFactory.initElements(driver, this);

	}

	public String GetOnLoginPage() {
		driver.get("http://the-internet.herokuapp.com/login");
		return driver.getTitle();
	}

	public void EnterUsernamePassword(String userName, String pwd) {

//		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(username)).sendKeys(userName);
		username.sendKeys(userName);
		password.sendKeys(pwd);
	}

	public void clickOnLogin() {
		loginButton.click();
	}

	public boolean SuccessfulLoginCheck() {
		return logInSuccessMsg.getText().contains("You logged into a secure area!");
	}

}
