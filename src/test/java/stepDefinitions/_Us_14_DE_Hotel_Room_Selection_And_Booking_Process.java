package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;

public class _Us_14_DE_Hotel_Room_Selection_And_Booking_Process {

    DialogContent dc = new DialogContent();

    String checkIndate = "20092025";
    int checkInDay = Integer.parseInt(checkIndate.substring(0, 2));
    String checkOutDate = "27092025";
    int checkOutDay = Integer.parseInt(checkOutDate.substring(0, 2));
    int holidayDayNumber = (checkOutDay - checkInDay);
    int randomRoom;


    @When("The customer click JetztBuchen button")
    public void theCustomerClickJetztBuchenButton() {
        dc.clickFunction(dc.jetztBuchenButton);
    }

    @And("The customer enters checkin and checkout dates")
    public void theCustomerEntersCheckinAndCheckoutDates() {
    }

    @And("The customer click suchen button")
    public void theCustomerClickSuchenButton() {
    }

    @When("The customer chooses the number of adults,chilren,and rooms")
    public void theCustomerChoosesTheNumberOfAdultsChilrenAndRooms() {
    }

    @Then("The Customer verifies adult and child choices with information on the maximum number of rooms")
    public void theCustomerVerifiesAdultAndChildChoicesWithInformationOnTheMaximumNumberOfRooms() {
    }

    @Then("The Customer chooses the number of rooms and verify")
    public void theCustomerChoosesTheNumberOfRoomsAndVerify() {
    }
}
