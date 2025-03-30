package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Provide public getTest() so we can add steps from step definitions
    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentSparkReporter
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Test Report");
        spark.config().setTheme(Theme.STANDARD);

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Tester");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test node in the report
        String testName = result.getName();
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure and exception
        test.get().fail(result.getThrowable());

        try {
            String screenshotPath = utils.ScreenshotHelper.captureScreenshot(
                utils.DriverManager.getDriver(),
                result.getMethod().getMethodName()
            );
            test.get().addScreenCaptureFromPath(screenshotPath, "Failed Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }

        utils.DriverManager.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped
        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report
        extent.flush();
    }
}
