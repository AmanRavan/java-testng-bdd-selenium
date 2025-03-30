package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import logger.LoggerHelper;

import java.time.Duration;

/**
 * DriverManager is a utility class for managing WebDriver instances.
 * It provides methods to initialize WebDriver for different browsers.
 */
public class DriverManager {

    private static final Logger logger = LoggerHelper.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Get a WebDriver instance for the specified browser
     * The name of the browser (e.g., "chrome", "firefox", "ie")
     * @return a WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    logger.info("Setting up ChromeDriver.");
                    WebDriverManager.chromedriver().setup();
                    String isHeadless = new config.ConfigReader().getProperty("headless");
                    if (isHeadless != null && isHeadless.equalsIgnoreCase("true")) {
                        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
                        options.addArguments("--headless");
                        driver.set(new org.openqa.selenium.chrome.ChromeDriver(options));
                    } else {
                        driver.set(new org.openqa.selenium.chrome.ChromeDriver());
                    }
                    break;
                case "firefox":
                    logger.info("Setting up FirefoxDriver.");
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                    logger.info("Setting up InternetExplorerDriver.");
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                default:
                    logger.error("Browser not supported: " + browser);
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            if(new config.ConfigReader().getProperty("maximize.window").equalsIgnoreCase("true")){
                driver.get().manage().window().maximize();
            }
            String implicitWait = new config.ConfigReader().getProperty("implicit.wait");
            String pageLoadTimeout = new config.ConfigReader().getProperty("page.load.timeout");
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)))
                    .pageLoadTimeout(Duration.ofSeconds(Long.parseLong(pageLoadTimeout)));
            logger.info(browser + " WebDriver setup complete.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            logger.info("Quitting WebDriver.");
            driver.get().quit();
            driver.remove();
        }
    }
}
