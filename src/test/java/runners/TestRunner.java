package runners;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.*;
import testBase.TestBase;
import java.util.*;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepDefinitions"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@smoke",
        monochrome = true, //Don't colour terminal output.
        dryRun = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    public TestBase testBase;

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setUp(String browser) throws Exception {
        testBase = new TestBase();
        testBase.createBrowser(browser).get("https://opensource-demo.orangehrmlive.com/index.php/");

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("Execute me ");
        testBase.driverManager.closeDriver();
    }
}
