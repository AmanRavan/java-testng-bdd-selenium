package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import logger.LoggerHelper;
import java.time.Duration;

/**
 * WaitHelper is a utility class for managing explicit waits in Selenium WebDriver.
 * It provides methods to wait for various conditions.
 */
public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerHelper.getLogger(WaitHelper.class);

    /**
     * Constructor to initialize WaitHelper with a WebDriver instance.
     *
     * @param driver the WebDriver instance
     */
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        String explicitWait = new config.ConfigReader().getProperty("explicit.wait");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(explicitWait)));
        logger.info("WaitHelper initialized with WebDriver.");
    }

    /**
     * Wait for the visibility of the specified element.
     *
     * @param element the WebElement to wait for
     */
    public void waitForVisibility(WebElement element) {
        logger.debug("Waiting for visibility of element: " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for the element to be clickable.
     *
     * @param element the WebElement to wait for
     */
    public void waitForElementToBeClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for the presence of an element located by a specific locator.
     *
     * @param locator the locator to find the element
     */
    public void waitForPresenceOfElementLocated(org.openqa.selenium.By locator) {
        logger.debug("Waiting for presence of element located by: " + locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for the text to be present in the specified element.
     *
     * @param element the WebElement to check
     * @param text    the text to wait for
     */
    public void waitForTextToBePresentInElement(WebElement element, String text) {
        logger.debug("Waiting for text '" + text + "' to be present in element: " + element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForVisibilityOfElementLocated(org.openqa.selenium.By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
