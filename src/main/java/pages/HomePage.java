package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    // Locators
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with elements
    public void enterSearchKeyword(String keyword) {
        enterText(searchInput, keyword);
    }

    public void clickSearchButton() {
        click(searchButton);
    }
}