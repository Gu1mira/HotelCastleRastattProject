package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.GWD;

@CucumberOptions(
        tags = "@RegressionTest",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions", "hooks"}
)

public class RegressionTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public static void writeExtendReport(@Optional("chrome") String browserType) {
        GWD.threadBrowserName.set(browserType);
    }
}
