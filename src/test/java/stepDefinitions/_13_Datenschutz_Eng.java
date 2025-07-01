package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GWD;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _13_Datenschutz_Eng {
    private final WebDriver driver = GWD.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final SoftAssert softAssert = new SoftAssert();
    private final List<String> failedLinks = new ArrayList<>();


    @When("The user clicks on all active links and opens them one by one")
    public void theUserClicksOnAllActiveLinksAndOpensThemOneByOne() {
        List<WebElement> anchorElements = driver.findElements(By.tagName("a"));
        String originalWindow = driver.getWindowHandle();


        for (int i = 45; i <= 67 && i < anchorElements.size(); i++) {
            try {
                WebElement anchor  = anchorElements.get(i);
                String linkHref = anchor.getAttribute("href");

                if (linkHref == null || linkHref.isEmpty()) {
                    System.out.println("Skipping element " + i + " (no href)");
                    continue;}
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", linkHref);
                wait.until(d -> driver.getWindowHandles().size() > 1);

                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(originalWindow)) {
                        driver.switchTo().window(handle);
                        break;
                    }
                }
                wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));


                boolean pageIsValid = true;
                try {
                    String title = driver.getTitle();
                    String bodyText = "";
                    try {
                        bodyText = driver.findElement(By.tagName("body")).getText().toLowerCase();
                    } catch (Exception e) {
                        System.out.println("Body not found or unreadable.");
                    }

                    boolean titleSays404 = title != null && (
                            title.toLowerCase().contains("404") ||
                                    title.toLowerCase().contains("not found")
                    );

                    boolean bodyHasSevereError = bodyText.contains("this page isn’t available") ||
                            bodyText.contains("page not found") ||
                            bodyText.contains("error 404") ||
                            bodyText.contains("http error") ||
                            bodyText.contains("server error") ||
                            bodyText.contains("oops! page") ||
                            bodyText.contains("not exist");

                    pageIsValid = !(titleSays404 || bodyHasSevereError);

                } catch (Exception contentCheckEx) {
                    pageIsValid = false;
                    System.out.println("Content check failed for: " + linkHref);
                }

                if (!pageIsValid) {
                    failedLinks.add("❌ Broken or invalid page: " + linkHref);
                    softAssert.fail("❌ Invalid page: " + linkHref);
                } else {
                    System.out.println("✅ Valid page for link " + i + ": " + linkHref);
                }

                driver.close();
                driver.switchTo().window(originalWindow);

            } catch (Exception e) {
                failedLinks.add("❌ Exception at link index " + i + ": " + e.getMessage());
                softAssert.fail("Exception at link " + i + ": " + e.getMessage());
                try {
                    driver.close();
                    driver.switchTo().window(originalWindow);
                } catch (Exception ignore) {
                }
            }
        }

    }

    @Then("The user verifies redirection to correct webpages")
    public void theUserVerifiesRedirectionToCorrectWebpages() {
        if (!failedLinks.isEmpty()) {
            System.out.println("Broken Links Found:");
            failedLinks.forEach(System.out::println);
        }
        softAssert.assertAll();
    }
}

