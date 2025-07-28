package hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.GWD;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            // 1. Byte[] as screenshot → Cucumber HTML
            byte[] bytes = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", "screenshot name");

            // 2. File as screenshot → For ExtentReports
            String screenshotPath = getScreenshotFilePath(scenario.getName());

            try {
                File source = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File(screenshotPath));

                // 3. Adds a screenshot to the extent report
                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("../" + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        GWD.quitDriver();
    }

    private String getScreenshotFilePath(String scenarioName) {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_"); // Safe name
        return "test-output/screenshots/" + fileName + "_" + date + ".png";
    }
}

