package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;

public class _Us_14_DE_Hotel_Room_Selection_And_Booking_Process_Steps {

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

        dc.clickFunction(dc.checkInPLc);
        dc.pressCtrlA();
        dc.checkInPLc.sendKeys(checkIndate);
        dc.tabKeyMultiplePress(1);
        dc.checkOutPLc.sendKeys(checkOutDate);
    }

    @And("The customer click suchen button")
    public void theCustomerClickSuchenButton() {
        dc.clickFunction(dc.suchenButton);
    }

    @When("The customer chooses the number of adults,chilren,and rooms")
    public void theCustomerChoosesTheNumberOfAdultsChilrenAndRooms() {

        dc.wait(3);
        randomRoom = dc.randomGenerator(dc.maximaleBelegungList.size());

        dc.clickFunction(dc.ErwachseneList.get(randomRoom));
        dc.clickFunction(dc.ErwachseneSelect.get(dc.randomGenerator(dc.ErwachseneSelect.size())));
        dc.clickFunction(dc.KinderList.get(randomRoom));
        dc.jsClick(dc.KinderSelect.get(dc.randomGenerator(dc.KinderSelect.size())));

        dc.jsClick(dc.ZimmerList.get(randomRoom));
        if (dc.roomName.get(randomRoom).getText().equals("Einzelzimmer Standard")) {
            int a = Integer.parseInt(dc.availableRoom.get(0).getText().replaceAll("[^0-9,.]", ""));
            dc.clickFunction(dc.ZimmerSelect.get((int) (Math.random() * a) + 1));
        } else if (dc.roomName.get(randomRoom).getText().equals("Doppelzimmer Standard")) {
            int b = Integer.parseInt(dc.availableRoom.get(1).getText().replaceAll("[^0-9,.]", ""));
            dc.clickFunction(dc.ZimmerSelect.get((int) (Math.random() * b) + 1));
        } else if (dc.roomName.get(randomRoom).getText().equals("Doppelzimmer Komfort")) {
            dc.clickFunction(dc.ZimmerSelect.get((int) (Math.random() * 10) + 1));
        } else if (dc.roomName.get(randomRoom).getText().equals("Familien Suite (Dreibettzimmer)")) {
            int c = Integer.parseInt(dc.availableRoom.get(2).getText().replaceAll("[^0-9,.]", ""));
            dc.clickFunction(dc.ZimmerSelect.get((int) (Math.random() * c) + 1));
        }
    }

    @Then("The Customer verifies adult and child choices with information on the maximum number of rooms")
    public void theCustomerVerifiesAdultAndChildChoicesWithInformationOnTheMaximumNumberOfRooms() {
    }

    @Then("The Customer chooses the number of rooms and verify")
    public void theCustomerChoosesTheNumberOfRoomsAndVerify() {
    }
}
