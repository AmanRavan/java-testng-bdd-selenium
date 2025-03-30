package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.Logger;
import logger.LoggerHelper;
import java.time.Duration;

/**
 * BasePage is a base class for all page objects.
 * It contains common methods and utilities for interacting with web elements.
 */
public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    private static final Logger logger = LoggerHelper.getLogger(BasePage.class);

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.jsExecutor = (JavascriptExecutor) driver;
        logger.info("BasePage initialized with WebDriver.");
    }

    /**
     * Wait for the visibility of the specified element.
     *
     * @param element the WebElement to wait for
     */
    protected void waitForVisibility(WebElement element) {
        logger.debug("Waiting for visibility of element: " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Click on the specified element.
     *
     * @param element the WebElement to click
     */
    protected void click(WebElement element) {
        logger.info("Clicking on element: " + element);
        waitForVisibility(element);
        element.click();
    }

    /**
     * Enter text into the specified input field.
     *
     * @param element the WebElement representing the input field
     * @param text    the text to enter
     */
    protected void enterText(WebElement element, String text) {
        logger.info("Entering text '" + text + "' into element: " + element);
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }


    /**
     * Scroll to the specified element using JavaScript.
     *
     * @param element the WebElement to scroll to
     */
    public void scrollToElement(WebElement element) {
        logger.info("Scrolling to element: " + element);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Check if the specified element is displayed.
     *
     * @param element the WebElement to check
     * @return true if the element is displayed, false otherwise
     */
    public boolean isElementDisplayed(WebElement element) {
        logger.debug("Checking if element is displayed: " + element);
        try {
            waitForVisibility(element);
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.error("Element not displayed: " + element, e);
            return false;
        }
    }
}