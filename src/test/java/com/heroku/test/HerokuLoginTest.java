package com.heroku.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.heroku.pages.HerokuLoginPage;
import com.heroku.utils.BaseUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HerokuLoginTest extends BaseUtils {

	HerokuLoginPage login;

	public HerokuLoginTest() throws Exception {
		super();
		initialize();
		login = new HerokuLoginPage();
	}

	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
		assertEquals("The Internet", login.GetOnLoginPage());
	}

	@When("^user enters valid \"(.*)\" and \"(.*)\"$")
	public void user_enters_valid_username_and_password(String userName, String pwd) {
		login.EnterUsernamePassword(userName, pwd);
	}

	@Then("^user click on login$")
	public void user_click_on_login() {
		login.clickOnLogin();
	}

	@Then("^user will get account access$")
	public void user_will_get_account_access() {
		assertTrue(login.SuccessfulLoginCheck());
	}

	@And("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
