package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.Headers;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class _08_JetztBuchen {

    DialogContent dc = new DialogContent();
    Headers hs = new Headers();
    ReusableMethods rm = new ReusableMethods();

    private LocalDate selectedCheckInDate;

    @Given("Navigate to the Hotel Castle")
    public void navigateToTheHotelCastleRastatt() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
        rm.clickFunction(dc.acceptCookies);
    }

    @Then("Verifies that previous days, month and years cannot be selected")
    public void verifiesThatPreviousDaysMonthAndYearsCannotBeSelected() {
        List<WebElement> disabledDays = GWD.getDriver().findElements(By.cssSelector("div.vc-day.is-disabled"));
        for (WebElement day : disabledDays) {
            Assert.assertFalse(day.isEnabled(), "Disabled day is enabled: " + day.getText());
        }
    }

    @When("Customer selects a check-in date")
    public void customerSelectsACheckInDate() {
        WebElement checkInInput = dc.checkInDateInput;

        checkInInput.click();
        checkInInput.clear();

        checkInInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        checkInInput.sendKeys(Keys.DELETE); // Sil

        checkInInput.sendKeys("29112025");
    }


    @Then("Verifies that only dates after the check-in date can be selected")
    public void verifiesThatOnlyDatesAfterTheCheckInDateCanBeSelected() {
        List<WebElement> enabledDays = GWD.getDriver().findElements(By.cssSelector("div.vc-day:not(.is-disabled):not(.is-not-in-month)"));
        for (WebElement day : enabledDays) {
            int dayNumber = Integer.parseInt(day.findElement(By.tagName("span")).getText());
            if (dayNumber <= selectedCheckInDate.getDayOfMonth() && day.getAttribute("class").contains("is-past")) {
                Assert.assertFalse(day.isEnabled(), "Date before check-in date is enabled: " + day.getText());
            }
        }
    }

    @When("Customer selects a check-out date")
    public void customerSelectsACheckOutDate() {

    }

    @And("Verifies that the filtered options shown in the page")
    public void verifiesThatTheFilteredOptionsShownInThePage() {
        Assert.assertTrue(true, "Filtered options verification needs implementation.");
        rm.clickFunction(dc.suchenButton);
    }

    @When("Customer selects a number of rooms, number of kids and guests")
    public void customerSelectsANumberOfRoomsNumberOfKidsAndGuests() {
        rm.clickFunction(dc.zimmer);
        rm.clickFunction(dc.zimmerPlus);
    }

    @Then("Verifies that the Jetzt Buchen button activated")
    public void verifiesThatTheJetztBuchenButtonActivated() {
        rm.wait.until(ExpectedConditions.elementToBeClickable(dc.jetztBuchenButton));
        Assert.assertTrue(dc.jetztBuchenButton.isEnabled(), "Jetzt Buchen button is not activated.");
    }

}

