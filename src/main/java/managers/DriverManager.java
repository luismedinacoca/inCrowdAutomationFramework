package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Lama on 2021-01-21.
 */


public class DriverManager {
    private WebDriver driver;
    //private static DriverType driverType;
    private  DriverType driverType;
    private  EnvironmentType environmentType;
    //private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String MICROSOFT_EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
    private String projectPath = System.getProperty("user.dir");

    public DriverManager(DriverType browserEnun) {
        driverType = browserEnun;
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }


    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, projectPath + "/src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case MICROSOFT_EDGE :
                System.setProperty(MICROSOFT_EDGE_DRIVER_PROPERTY, projectPath+ "/src/test/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        //if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        getDriver().manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

}