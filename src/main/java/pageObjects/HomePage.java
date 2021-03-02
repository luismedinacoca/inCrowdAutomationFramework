package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lama on 2021-02-18.
 */
public class HomePage {

    WebDriver driver;
    @FindBy(id = "welcome")
    private WebElement welcomeText;
    @FindBy(xpath = "//div[@id='welcome-menu']//a[text()='logout']")
    private WebElement logout;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyWelcomeTextDisplayed() {
        return welcomeText.isDisplayed();
    }

    public void clickLogout() {
        logout.click();
    }

}
