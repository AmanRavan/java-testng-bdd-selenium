package utils;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "reports/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
