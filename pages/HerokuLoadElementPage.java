package com.heroku.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.heroku.utils.BaseUtils;

public class HerokuLoadElementPage extends BaseUtils {

	@FindBy(xpath = "//button[text()=\"Start\"]")
	WebElement startButton;

	@FindBy(xpath = "//div[@id=\"finish\"]//h4[text()=\"Hello World!\"]")
	WebElement waitElement;

	public HerokuLoadElementPage() {
		PageFactory.initElements(driver, this);
	}

	public String getWaitingElement() {

		startButton.click();

		return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(waitElement)).getText();

	}

}
