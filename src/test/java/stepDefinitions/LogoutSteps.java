package stepDefinitions;

import io.cucumber.java.en.Given;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class LogoutSteps extends TestBase {
    TestBase testBase = new TestBase();
    HomePage homePage = testBase.getPageObjectManager().getHomePage();

    @Given("user clicks on Logout button")
    public void user_clicks_on_logout_button() {
        homePage.clickLogout();
    }
}
