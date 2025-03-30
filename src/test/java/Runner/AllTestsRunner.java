package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import reports.ExtentReportListener;

@Listeners(ExtentReportListener.class)
@CucumberOptions(
        features = {"src/test/resources/features/allTests.feature"},
        glue = {"stepDefinitions","utils"},
        plugin = {"pretty", "html:target/cucumber-reports-all.html", "json:target/cucumber-all.json"},
        monochrome = true
)
public class AllTestsRunner extends AbstractTestNGCucumberTests {
}
