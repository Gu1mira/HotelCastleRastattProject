package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
    }

    @And("Verifies that the date container displays for the check-in date")
    public void verifiesThatTheDateContainerDisplaysForTheCheckInDate() {
        Assert.assertTrue(dc.datePicker.isDisplayed(), "Check-in date container is not displayed.");
    }

    @Then("Verifies that previous days, month and years cannot be selected")
    public void verifiesThatPreviousDaysMonthAndYearsCannotBeSelected() {

        int todayDay = LocalDate.now().getDayOfMonth();
        int initiallySelectedDay = Integer.parseInt(dc.selectedDay.findElement(By.tagName("p")).getText());

        String xpathForToday = "//div[contains(@class,'day') and p[text()='" + todayDay + "']]";

        WebElement todayElement = GWD.getDriver().findElement(By.xpath(xpathForToday));
        for (int i = 1; i <= 3; i++) {
            int dayToTest = todayDay - i;

            WebElement dayElement = null;

            for (WebElement dayP : dc.enabledDays) {
                String text = dayP.getText();

                if (!text.matches("\\d+")) {
                    continue; // sayı değilse atla
                }


                int dayNumber = Integer.parseInt(dayP.getText());
                if (dayNumber == dayToTest) {
                    dayElement = dayP.findElement(By.xpath("./..")); // <p> elementinin parent div'i
                    break;
                }
            }

            if (dayElement == null) {
                continue;
            }


            ((JavascriptExecutor) GWD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", dayElement);
            rm.wait.until(ExpectedConditions.elementToBeClickable(dayElement));

            ((JavascriptExecutor) GWD.getDriver()).executeScript("arguments[0].click();", dayElement);
            rm.wait.until(ExpectedConditions.textToBePresentInElement(dc.selectedDay.findElement(By.tagName("p")), String.valueOf(initiallySelectedDay)));

            int currentlySelectedDay = Integer.parseInt(dc.selectedDay.findElement(By.tagName("p")).getText());

            Assert.assertEquals(initiallySelectedDay, currentlySelectedDay, "Last days can not be chosen!");
        }

    }

    @When("Customer selects a check-in date")
    public void customerSelectsACheckInDate() {
        LocalDate now = LocalDate.now();
        LocalDate sixMonthsLater = now.plusMonths(6);

        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        int targetYear = sixMonthsLater.getYear();
        int targetMonth = sixMonthsLater.getMonthValue();
        int targetDay = sixMonthsLater.getDayOfMonth();


        int monthsToMove = (targetYear - currentYear) * 12 + (targetMonth - currentMonth);

        for (int i = 0; i < monthsToMove; i++) {
            rm.clickFunction(dc.arrow);
        }

        String dayXpath = "//div[contains(@class,'day') and p[text()='" + targetDay + "']]";
        WebElement dayElement = rm.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));

        try {
            dayElement.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", dayElement);
            js.executeScript("arguments[0].click();", dayElement);
        }
    }

    @Then("Verifies that date container displays for the check-out date")
    public void verifiesThatDateContainerDisplaysForTheCheckOutDate() {
        Assert.assertTrue(dc.datePicker.isDisplayed(), "Check-in date container is not displayed.");
    }

    @Then("Verifies that only dates after the check-in date can be selected")
    public void verifiesThatOnlyDatesAfterTheCheckInDateCanBeSelected() {
        int checkInDay = selectedCheckInDate.getDayOfMonth();

        for (WebElement dayP : dc.enabledDays) {
            int dayNumber = Integer.parseInt(dayP.getText());
            WebElement dayElement = dayP.findElement(By.xpath("./..")); // parent div.day

            if (dayNumber <= checkInDay) {
                dayElement.click();

                int currentlySelectedDay = Integer.parseInt(dc.selectedDay.findElement(By.tagName("p")).getText());
                Assert.assertEquals(checkInDay, currentlySelectedDay, "Dates before the check-in date, cannot be chosen!");

            }
        }
    }


    @When("Customer selects a check-out date")
    public void customerSelectsACheckOutDate() {
    }

    @And("Verifies that the filtered options shown in the page")
    public void verifiesThatTheFilteredOptionsShownInThePage() {
    }

    @When("Customer selects a number of rooms, number of kids and guests")
    public void customerSelectsANumberOfRoomsNumberOfKidsAndGuests() {
    }

    @Then("Verifies that the Jetzt Buchen button activated")
    public void verifiesThatTheJetztBuchenButtonActivated() {
    }
}
