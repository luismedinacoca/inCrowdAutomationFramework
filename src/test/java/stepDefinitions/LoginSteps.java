package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LoginPage;
import testBase.TestBase;

import java.io.IOException;

public class LoginSteps extends TestBase {
    TestBase testBase= new TestBase();
    LoginPage loginPage = testBase.getPageObjectManager().getLoginPage();

    @Given("user enter username {string} and password {string} to login")
    public void user_enter_username_and_password_to_login(String string, String string2) throws IOException, InterruptedException {
        loginPage.enterUserName(string);
        loginPage.enterPassword(string2);
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Given("user is on the {string} screen")
    public void user_is_on_the_screen(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(string);
    }
}
