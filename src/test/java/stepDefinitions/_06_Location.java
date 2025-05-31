package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

import java.time.Duration;

public class _06_Location {

    DialogContent dc = new DialogContent();

    @Given("Navigate to the Hotel Castle Rastatt in German")
    public void navigateToHotelCastleRastattInGerman() {
        WebDriver driver = GWD.getDriver();
        driver.get("https://hotel-castle-rastatt.de/?lang=de");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                webDriver -> webDriver.getCurrentUrl().contains("lang"));
        if (driver.getCurrentUrl().contains("?lang=en")) {
            driver.get("https://hotel-castle-rastatt.de/?lang=de");

        }
    }

    @When("The user clicks on the Anfahrt tab from the top menu")
    public void theUserClicksOnTheAnfahrtTabFromTheTopMenu() {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.anfahrtTab);

    }

    @And("The user should see German language on the page")
    public void theUserShouldSeeGermanLanguageOnThePage() {
        String expectedParagraph = "Das Castle Hotel Rastatt befindet sich direkt neben dem Hauptbahnhof Rastatt und ist somit sehr bequem per Zug, Bus oder S-Bahn zu erreichen. Auch die Anfahrt per Auto ist aufgrund der Nähe zur Autobahn A5 ein Leichtes. Außerdem haben Sie kostenfreie Parkmöglichkeiten direkt am Hotel.";
        Assert.assertEquals(dc.explanatoryText.getText().trim(), expectedParagraph);
    }

    @And("The user clicks on the English language option icon in the top right corner of the header menu")
    public void theUserClicksOnTheEnglishLanguageOptionIconInTheTopRightCornerOfTheHeaderMenu() {

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.englishLanguageIcon);

    }

    @And("The user should see {string} and the explanatory text below it")
    public void theUserShouldSeeAndTheExplanatoryTextBelowIt(String expectedText) {

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        WebElement englishText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='textwidget']/p")));
        Assert.assertTrue(englishText.getText().contains("Castle Hotel Rastatt"));
    }

    @And("The user should see Google Maps correctly")
    public void theUserShouldSeeGoogleMapsCorrectly() {

        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(15));
        WebElement mapsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href, 'google.com/maps')]")
        ));

        Assert.assertTrue(mapsLink.isDisplayed(), "Google Maps link is not visible");


    }
}
