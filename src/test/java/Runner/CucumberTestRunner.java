package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Listeners;
import reports.ExtentReportListener;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
@Listeners(ExtentReportListener.class)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    // This class will automatically run all feature files in the specified directory
}
