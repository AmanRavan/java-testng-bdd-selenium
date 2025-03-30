package stepDefinitions;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logger.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import testBase.BaseTest;
import utils.WaitHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions extends BaseTest {

    private WaitHelper waitHelper;
    private BasePage basePage;
    private static final Logger logger = LoggerHelper.getLogger(WaitHelper.class);

    @Before
    public void setUpCucumber(Scenario scenario) {
        String browser = new ConfigReader().getProperty("browser");
        super.setUp(browser);
        basePage = new BasePage(driver);
        this.waitHelper = new WaitHelper(driver);
    }

    @Given("I navigate to the careers website")
    public void i_navigate_to_the_careers_website() {
        reports.ExtentReportListener.getTest().info("Navigating to the careers website");
        String baseUrl = new ConfigReader().getProperty("base.url");
        driver.get(baseUrl);
        reports.ExtentReportListener.getTest().pass("Have successfully navigated to the website: " + baseUrl);
    }

    @When("I handle the cookies alert")
    public void i_handle_the_cookies_alert() {
        try {
            Actions actions = new Actions(driver);
            actions.moveByOffset(756, 533).click().perform();
            reports.ExtentReportListener.getTest().info("Click on Deny and Continue for cookies");
        } catch (Exception e) {
            logger.warn("Cookies alert not found or already handled.");
            reports.ExtentReportListener.getTest().info("Cookie popup did not appear.");
        }
    }

    @When("I click on the {string} button for professionals")
    public void i_click_on_the_button_for_professionals(String buttonName) {
        WebElement moreButton = driver.findElement(By.xpath("(//a[@title='Professionals'])[4]"));
        waitHelper.waitForElementToBeClickable(moreButton);
        moreButton.click();
        reports.ExtentReportListener.getTest().info("Have successfully clicked on More jobs in professionals");
    }

    @Then("I should see the {string} heading")
    public void i_should_see_the_heading(String headingText) {
        waitHelper.waitForPresenceOfElementLocated(By.xpath("//h3[normalize-space()='Search by:']"));
        WebElement heading = driver.findElement(By.xpath("//h3[normalize-space()='Search by:']"));
        waitHelper.waitForVisibility(heading);
        String actual = heading.getText().trim();
        System.out.println("DEBUG: heading text is: " + actual);
        assertThat(actual).contains(headingText)
                .withFailMessage("Expected heading text to contain: '%s', but got: '%s'", headingText, actual);
        reports.ExtentReportListener.getTest().info("Have successfully navigated to jobs page for professional");
    }

    @When("I select {string} from the Division Category dropdown")
    public void i_select_from_the_division_category_dropdown(String division) {
        waitHelper.waitForElementToBeClickable(driver.findElement(By.id("vs1__combobox")));
        WebElement combobox = driver.findElement(By.id("vs1__combobox"));
        basePage.scrollToElement(combobox);
        combobox.click();

        waitHelper.waitForVisibilityOfElementLocated(By.xpath("//ul[@id='vs1__listbox']"));
        WebElement dropdown = driver.findElement(By.xpath("//ul[@id='vs1__listbox']"));

        WebElement divisionOption = dropdown.findElement(By.xpath("//li[contains(text(), '" + division + "')]"));
        basePage.scrollToElement(divisionOption);
        if(!basePage.isElementDisplayed(divisionOption)){
            reports.ExtentReportListener.getTest().warning("Division option is not visible: " + division);
        }
        divisionOption.click();
        reports.ExtentReportListener.getTest().info("Have successfully selected the Value from Division Dropdown. Selected Value =" + division);
    }

    @When("I select {string} from the Country dropdown")
    public void i_select_from_the_country_dropdown(String country) {
        waitHelper.waitForElementToBeClickable(driver.findElement(By.id("vs2__combobox")));
        WebElement combobox = driver.findElement(By.id("vs2__combobox"));
        basePage.scrollToElement(combobox);
        combobox.click();

        waitHelper.waitForVisibilityOfElementLocated(By.xpath("//ul[@id='vs2__listbox']"));
        WebElement countryOption = driver.findElement(By.xpath("//li[contains(text(), '" + country + "')]"));
        basePage.scrollToElement(countryOption);
        if(!basePage.isElementDisplayed(countryOption)){
            reports.ExtentReportListener.getTest().warning("Country option is not visible: " + country);
        }
        countryOption.click();
        reports.ExtentReportListener.getTest().info("Have successfully selected the Value from Country Dropdown. Selected Value =" + country);
    }

    @When("I select {string} from the Corporate title dropdown")
    public void i_select_from_the_corporate_title_dropdown(String title) {
        waitHelper.waitForElementToBeClickable(driver.findElement(By.id("vs3__combobox")));
        WebElement combobox = driver.findElement(By.id("vs3__combobox"));
        basePage.scrollToElement(combobox);
        combobox.click();

        waitHelper.waitForVisibilityOfElementLocated(By.xpath("//ul[@id='vs3__listbox']"));
        WebElement titleOption = driver.findElement(By.xpath("//li[contains(text(), '" + title + "')]"));
        basePage.scrollToElement(titleOption);
        if(!basePage.isElementDisplayed(titleOption)){
            reports.ExtentReportListener.getTest().warning("Title option is not visible: " + title);
        }
        titleOption.click();
        reports.ExtentReportListener.getTest().info("Have successfully selected the Value from Corporate Dropdown. Selected Value =" + title);
    }

    @When("I select {string} from the availability dropdown")
    public void i_select_from_the_availability_dropdown(String availability) {
        waitHelper.waitForElementToBeClickable(driver.findElement(By.id("vs4__combobox")));
        WebElement combobox = driver.findElement(By.id("vs4__combobox"));
        basePage.scrollToElement(combobox);
        combobox.click();

        waitHelper.waitForVisibilityOfElementLocated(By.xpath("//ul[@id='vs4__listbox']"));
        WebElement availabilityOption = driver.findElement(By.xpath("//li[contains(text(), '" + availability + "')]"));
        basePage.scrollToElement(availabilityOption);
        if(!basePage.isElementDisplayed(availabilityOption)){
            reports.ExtentReportListener.getTest().warning("Availability option is not visible: " + availability);
        }
        availabilityOption.click();
        reports.ExtentReportListener.getTest().info("Have successfully selected the Value from Availability Dropdown. Selected Value =" + availability);
    }

    @When("I enter {string} in the keyword input box")
    public void i_enter_in_the_job_id_keyword_input_box(String keyword) {
        WebElement keywordInput = driver.findElement(By.xpath("//input[@id='jobIdSearch']"));
        keywordInput.clear();
        keywordInput.sendKeys(keyword);
        reports.ExtentReportListener.getTest().info("Have successfully entered text in input field. Selected Value ="+ keyword);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        waitHelper.waitForElementToBeClickable(searchButton);
        searchButton.click();
        reports.ExtentReportListener.getTest().info("Have successfully clicked on Search Button");
    }

    @Then("I should see search results containing the keyword {string}")
    public void i_should_see_search_results_containing_the_keyword(String keyword){
        List<WebElement> searchResultHighlights = driver.findElements(By.xpath("//div[@class='detail-entry']/h2"));
        waitHelper.waitForVisibility(searchResultHighlights.get(0));
        boolean keywordFound = searchResultHighlights.stream()
                .anyMatch(searchResultHighlight -> searchResultHighlight.getText().contains(keyword));
        assertThat(keywordFound)
                .withFailMessage("Search results do not contain the keyword: %s", keyword)
                .isTrue();
        reports.ExtentReportListener.getTest().info("Have successfully Verified. Search results do not contain the keyword:"+ keyword);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            reports.ExtentReportListener.getTest().info("Scenario: " + scenario.getName() + " failed. Quitting driver...");
        }
        utils.DriverManager.quitDriver();
    }
}
