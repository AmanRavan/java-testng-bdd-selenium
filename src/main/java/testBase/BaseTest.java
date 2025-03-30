package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import logger.LoggerHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.DriverManager;

/**
 * BaseTest is a base class for all test classes.
 * It contains setup and teardown methods for WebDriver and ExtentReports.
 */
public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LoggerHelper.getLogger(BaseTest.class);
    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        logger.info("Setting up WebDriver for browser: " + browser);
        driver = DriverManager.getDriver(browser);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver.");
            DriverManager.quitDriver();
        }

    }
}
