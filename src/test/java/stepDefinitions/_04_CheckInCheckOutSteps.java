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

public class _04_CheckInCheckOutSteps {
    DialogContent dc = new DialogContent();
    LocalDate today = LocalDate.now();
    YearMonth currentMonth = YearMonth.now();
    int dayOfMonth = today.getDayOfMonth();
    String dayOfMont = String.valueOf(dayOfMonth);
    String year = String.valueOf(today.getYear());
    String month = String.valueOf(today.getMonth());
    List<Integer> checkInPreviousDay = new ArrayList<>();
    List<String> previousDayStr = new ArrayList<>();
    int lastDayOfMonth = currentMonth.lengthOfMonth();
    int randomCheckInDate = (int) (Math.random() * (lastDayOfMonth - dayOfMonth + 1)) + dayOfMonth;
    List<Integer> checkOutPreviousDays = new ArrayList<>();
    int randomCheckOutDate = (int) (Math.random() * (lastDayOfMonth - randomCheckInDate)) + randomCheckInDate+1;
    String randomCheckInDateStr = String.valueOf(randomCheckInDate);
    String randomCheckOutDateStr = String.valueOf(randomCheckOutDate);
    String checkInDate = String.format("%02d", Integer.parseInt(randomCheckInDateStr))
            + "/" + String.format("%02d", today.getMonthValue())
            + "/" + year;
    String checkOutDate = String.format("%02d", Integer.parseInt(randomCheckOutDateStr))
            + "/" + String.format("%02d", today.getMonthValue())
            + "/" + year;
    LocalDate nextMonthDate = today.plusMonths(1);
    String nextMonthName = nextMonthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    String nextCheckOutRandomStr;
    String nextCheckOutDate;

    @Given("Navigate to the Hotel Castle Rastatt")
    public void navigateToTheHotelCastleRastatt() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
        dc.clickFunction(dc.acceptCookies);

    }

    @When("The customer click  on the english language icon")
    public void theCustomerClickOnTheEnglishLanguageIcon() {
        dc.clickFunction(dc.englishIcon);

    }

    @And("The customer clicks on the check-in calender icon")
    public void theCustomerClicksOnTheCheckInCalenderIcon() {
        dc.clickFunction(dc.checkInWidget);

    }

    @Then("Verifies that today's date, month and previous days cannot be selected")
    public void verifiesThatTodaySDateMonthAndPreviousDaysCannotBeSelected() {
        dayOfMonth = today.getDayOfMonth();
        dayOfMont = String.valueOf(dayOfMonth);
        year = String.valueOf(today.getYear());
        month = String.valueOf(today.getMonth());
        checkInPreviousDay = new ArrayList<>();
        previousDayStr = new ArrayList<>();

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
            if (day.getText().equals(dayOfMont)) {
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
        System.out.println(randomCheckInDate);
        dc.clickFunction(dc.checkIndateList.get(randomCheckInDate - 1));
    }

    @And("The customer clicks on the check-out calender icon")
    public void theCustomerClicksOnTheCheckOutCalenderIcon() {
        dc.clickFunction(dc.checkOutWidget);


    }

    @Then("Verifies that today's date, month, previous days and entry date cannot be selected")
    public void verifiesThatTodaySDateMonthPreviousDaysAndEntryDateCannotBeSelected() {

        for (int i = randomCheckInDate; i > 0; i--) {
            checkOutPreviousDays.add(i);
        }

        if ((randomCheckInDate) == (lastDayOfMonth)) {
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
        if (randomCheckInDate==lastDayOfMonth) {
            int nextCheckOutRandom = (int) (Math.random() *(lastDayOfMonth))+1;
            nextCheckOutRandomStr = String.valueOf(nextCheckOutRandom);
            nextCheckOutDate = String.format("%02d", Integer.parseInt(nextCheckOutRandomStr))
                    + "/" + String.format("%02d", today.plusMonths(1).getMonthValue())
                    + "/" + year;
            dc.clickFunction(dc.checkOutdateList.get(nextCheckOutRandom-1));

        } else {
            System.out.println(randomCheckOutDate);
            dc.clickFunction(dc.checkOutdateList.get(randomCheckOutDate - 1));
        }

    }

    @Then("Verifies check-in and check-out dates")
    public void verifiesCheckInAndCheckOutDates() {
        dc.wait.until(ExpectedConditions.attributeContains(dc.checkInWidget, "value", "2025"));
        dc.wait.until(ExpectedConditions.attributeContains(dc.checkOutWidget, "value", "2025"));
        System.out.println(dc.checkInWidget.getAttribute("value"));
        System.out.println(dc.checkOutWidget.getAttribute("value"));
        System.out.println(checkInDate);
        System.out.println(checkOutDate);

        dc.wait.until(ExpectedConditions.attributeToBe(dc.checkInWidget, "value", checkInDate));
        Assert.assertEquals(dc.checkInWidget.getAttribute("value"), checkInDate);

        if (randomCheckInDate==lastDayOfMonth){
            dc.wait.until(ExpectedConditions.attributeToBe(dc.checkOutWidget,"value",nextCheckOutDate));
            Assert.assertEquals(dc.checkOutWidget.getAttribute("value"), nextCheckOutDate);
            System.out.println(nextCheckOutDate);
        }else {
            dc.wait.until(ExpectedConditions.attributeToBe(dc.checkOutWidget, "value", checkOutDate));
            Assert.assertEquals(dc.checkOutWidget.getAttribute("value"), checkOutDate);
        }
    }

    @When("The customer clicks the GO button")
    public void theCustomerClicksTheGoButton() {
        dc.clickFunction(dc.goButton);
    }

    @Then("Verify redirection to the reservation page")
    public void verifyRedirectionToTheReservationPage() {
        dc.switchToWindow(1);
        String noReservation = "Es tut uns leid, aber für das angegebene Datum sind keine Unterkünfte verfügbar!";
        dc.wait.until(ExpectedConditions.urlContains("reservation"));
        dc.verifyContainsText(dc.hotelCastleRastattText, "Rastatt");
        System.out.println(dc.hotelCastleRastattText.getText());
        dc.wait.until(ExpectedConditions.attributeToBe(dc.spinnerContainer, "style", "display: none;"));
        if (!dc.messageContainer.isEmpty()) {
            Assert.assertTrue(dc.messageContainer.get(0).getText().contains(noReservation), "Expected message not found");
            System.out.println(dc.messageContainer.get(0).getText());
        } else if (!dc.availableRoom.isEmpty()) {
            Assert.assertTrue(dc.availableRoom.get(0).getText().contains("übrig"));
            System.out.println(dc.availableRoom.get(0).getText());
        }
    }
}
