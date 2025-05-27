package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DialogContent;
import pages.Headers;

public class _08_JetztBuchen {

    DialogContent dc = new DialogContent();
    Headers hs = new Headers();

    @And("Verifies that the date container displays for the check-in date")
    public void verifiesThatTheDateContainerDisplaysForTheCheckInDate() {
        Assert.assertTrue(dc.datePicker.isDisplayed(), "Check-in date container is not displayed.");
    }

    @Then("Verifies that previous days, month and years cannot be selected")
    public void verifiesThatPreviousDaysMonthAndYearsCannotBeSelected() {
    }

    @When("Customer selects a check-in date")
    public void customerSelectsACheckInDate() {
    }

    @Then("Verifies that date container displays for the check-out date")
    public void verifiesThatDateContainerDisplaysForTheCheckOutDate() {
    }

    @Then("Verifies that only dates after the check-in date can be selected")
    public void verifiesThatOnlyDatesAfterTheCheckInDateCanBeSelected() {
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
