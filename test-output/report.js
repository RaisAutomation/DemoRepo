$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Dell/eclipse-workspace/CucumberTestPOM/src/test/java/features/LogIn.feature");
formatter.feature({
  "line": 1,
  "name": "Heroku User LogIn",
  "description": "",
  "id": "heroku-user-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "HeroKu LogIn Page Test",
  "description": "",
  "id": "heroku-user-login;heroku-login-page-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is already on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters valid \"tomsmith\" and \"SuperSecretPassword!\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user click on login",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user will get account access",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HerokuLoginTest.user_is_already_on_login_page()"
});
formatter.result({
  "duration": 12126738800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tomsmith",
      "offset": 19
    },
    {
      "val": "SuperSecretPassword!",
      "offset": 34
    }
  ],
  "location": "HerokuLoginTest.user_enters_valid_username_and_password(String,String)"
});
formatter.result({
  "duration": 244110200,
  "status": "passed"
});
formatter.match({
  "location": "HerokuLoginTest.user_click_on_login()"
});
formatter.result({
  "duration": 842941800,
  "status": "passed"
});
formatter.match({
  "location": "HerokuLoginTest.user_will_get_account_access()"
});
formatter.result({
  "duration": 48414000,
  "status": "passed"
});
formatter.match({
  "location": "HerokuLoginTest.close_the_browser()"
});
formatter.result({
  "duration": 659225000,
  "status": "passed"
});
});