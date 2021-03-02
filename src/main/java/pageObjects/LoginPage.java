package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by Lama on 2021-02-14.
 */
public class LoginPage {

    WebDriver driver;
    @FindBy(id = "txtUsername")
    private WebElement username;
    @FindBy(id = "txtPassword")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")  /**changing id for xpath = > no more error in this locator*/
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        try {
            WebElement firstResult = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(loginButton));
            firstResult.click();
        } catch (Exception e) {
            e.printStackTrace();

            WebElement firstResult = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(loginButton));
            firstResult.click();
        }
    }
}


