package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class _US04_CheckInCheckOutSteps {

    LocalDate today = LocalDate.now();
    YearMonth currentMonth = YearMonth.now();
    int dayOfMonth = today.getDayOfMonth();
    String year = String.valueOf(today.getYear());
    String month = String.valueOf(today.getMonth());
    int lastDayOfMonth = currentMonth.lengthOfMonth();

    int randomCheckInDate = (int) (Math.random() * (lastDayOfMonth - dayOfMonth + 1)) + dayOfMonth;
    int randomCheckOutDate = (int) (Math.random() * (lastDayOfMonth - randomCheckInDate)) + randomCheckInDate + 1;

    String checkInDate = randomCheckInDate + "/" + String.format("%02d", today.getMonthValue()) + "/" + year;
    String checkOutDate = randomCheckOutDate + "/" + String.format("%02d", today.getMonthValue()) + "/" + year;

    LocalDate nextMonthDate = today.plusMonths(1);
    String nextMonthName = nextMonthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

    @Given("Navigate to the Hotel Castle Rastatt")
    public void navigateToTheHotelCastleRastatt() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
        new DialogContent().clickFunction(new DialogContent().acceptCookies);
    }

    @When("The customer click  on the english language icon")
    public void theCustomerClickOnTheEnglishLanguageIcon() {
        new DialogContent().clickFunction(new DialogContent().englishIcon);
    }

    @And("The customer clicks on the check-in calender icon")
    public void theCustomerClicksOnTheCheckInCalenderIcon() {
        new DialogContent().clickFunction(new DialogContent().checkInWidget);
    }

    @Then("Verifies that today's date, month and previous days cannot be selected")
    public void verifiesThatTodaySDateMonthAndPreviousDaysCannotBeSelected() {
        DialogContent dc = new DialogContent();
        List<Integer> checkInPreviousDay = new ArrayList<>();

        for (int i = dayOfMonth; i > 0; i--) {
            checkInPreviousDay.add(i);
        }

        for (int i = 0; i < dc.checkIndateList.size(); i++) {
            if (checkInPreviousDay.get(i) < dayOfMonth) {
                dc.wait.until(ExpectedConditions.visibilityOf(dc.checkIndateList.get(i)));
                Assert.assertEquals(dc.checkIndateList.get(i).getAttribute("class"), "is-disabled");
                break;
            }
        }

        for (WebElement day : dc.checkIndateList) {
            if (day.getText().equals(String.valueOf(dayOfMonth))) {
                dc.wait.until(ExpectedConditions.visibilityOf(day));
                Assert.assertEquals(day.getAttribute("class"), "is-today is-selected");
                break;
            }
        }

        for (WebElement Month : dc.checkInMonthNames) {
            if (Month.getText().toUpperCase().equals(month)) {
                Assert.assertTrue(Month.isSelected());
                Assert.assertEquals(dc.checkInPrevButton.getAttribute("class"), "pika-prev is-disabled");
                break;
            }
        }

        for (WebElement Year : dc.checkInYearNames) {
            if (Year.getText().equals(year)) {
                Assert.assertTrue(Year.isSelected());
                break;
            }
        }
    }

    @And("The customer enters  the check-in date")
    public void theCustomerEntersTheCheckInDate() {
        DialogContent dc = new DialogContent();
        dc.clickFunction(dc.checkIndateList.get(randomCheckInDate - 1));
    }

    @And("The customer clicks on the check-out calender icon")
    public void theCustomerClicksOnTheCheckOutCalenderIcon() {
        new DialogContent().clickFunction(new DialogContent().checkOutWidget);
    }

    @Then("Verifies that today's date, month, previous days and entry date cannot be selected")
    public void verifiesThatTodaySDateMonthPreviousDaysAndEntryDateCannotBeSelected() {
        DialogContent dc = new DialogContent();
        List<Integer> checkOutPreviousDays = new ArrayList<>();
        for (int i = randomCheckInDate; i > 0; i--) {
            checkOutPreviousDays.add(i);
        }

        if (randomCheckInDate == lastDayOfMonth) {
            for (WebElement Month : dc.checkOutMonthNames) {
                if (Month.getText().equals(nextMonthName)) {
                    Assert.assertTrue(Month.isSelected());
                }
            }
        } else {
            for (int i = 0; i < dc.checkOutdateList.size(); i++) {
                if (checkOutPreviousDays.get(i) < randomCheckInDate) {
                    dc.wait.until(ExpectedConditions.visibilityOf(dc.checkOutdateList.get(i)));
                    Assert.assertEquals(dc.checkOutdateList.get(i).getAttribute("class"), "is-disabled");
                    break;
                }
            }

            for (WebElement Year : dc.checkoutYearNames) {
                if (Year.getText().equals(year)) {
                    Assert.assertTrue(Year.isSelected());
                    break;
                }
            }
        }
    }

    @And("The customer enters  the check-out date")
    public void theCustomerEntersTheCheckOutDate() {
        DialogContent dc = new DialogContent();

        if (dc.checkIndateList.get(randomCheckInDate - 1).getText().equals(String.valueOf(lastDayOfMonth))) {
            dc.clickFunction(dc.checkOutdateList.get((int) (Math.random() * (lastDayOfMonth)) + 1));
        } else {
            dc.clickFunction(dc.checkOutdateList.get(randomCheckOutDate - 1));
        }
    }

    @Then("Verifies check-in and check-out dates")
    public void verifiesCheckInAndCheckOutDates() {
        DialogContent dc = new DialogContent();
        dc.wait.until(ExpectedConditions.attributeContains(dc.checkInWidget, "value", year));
        dc.wait.until(ExpectedConditions.attributeContains(dc.checkOutWidget, "value", year));
        dc.wait.until(ExpectedConditions.attributeToBe(dc.checkInWidget, "value", checkInDate));
        Assert.assertEquals(dc.checkInWidget.getAttribute("value"), checkInDate);
        dc.wait.until(ExpectedConditions.attributeToBe(dc.checkOutWidget, "value", checkOutDate));
        Assert.assertEquals(dc.checkOutWidget.getAttribute("value"), checkOutDate);
    }

    @When("The customer clicks the GO button")
    public void theCustomerClicksTheGoButton() {
        new DialogContent().clickFunction(new DialogContent().goButton);
    }

    @Then("Verify redirection to the reservation page")
    public void verifyRedirectionToTheReservationPage() {
        DialogContent dc = new DialogContent();
        dc.switchToWindow(1);
        String noReservation = "Es tut uns leid, aber für das angegebene Datum sind keine Unterkünfte verfügbar!";
        dc.wait.until(ExpectedConditions.urlContains("reservation"));
        dc.verifyContainsText(dc.hotelCastleRastattText, "Rastatt");
        dc.wait.until(ExpectedConditions.attributeToBe(dc.spinnerContainer, "style", "display: none;"));

        if (!dc.messageContainer.isEmpty()) {
            Assert.assertTrue(dc.messageContainer.get(0).getText().contains(noReservation));
        } else if (!dc.availableRoom.isEmpty()) {
            Assert.assertTrue(dc.availableRoom.get(0).getText().contains("übrig"));
        }
    }
}
