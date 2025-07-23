package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;

public class _Us_14_DE_Hotel_Room_Selection_And_Booking_Process_Steps {

    DialogContent dc = new DialogContent();

    String checkIndate = dc.dateCreate(1);
    int checkInDay = Integer.parseInt(checkIndate.substring(0, 2));
    String checkOutDate = dc.dateCreate(8);
    int checkOutDay = Integer.parseInt(checkOutDate.substring(0, 2));
    int holidayDayNumber = (checkOutDay - checkInDay);
    int randomRoom;

    @When("The customer click JetztBuchen button")
    public void theCustomerClickJetztBuchenButton() {
        dc.clickFunction(dc.jetztBuchenButton);
    }

    @And("The customer enters check in and checkout dates")
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

    @When("The customer chooses the number of adults,children,and rooms")
    public void theCustomerChoosesTheNumberOfAdultsChildrenAndRooms() {

        dc.wait.until(ExpectedConditions.attributeToBe(dc.spinnerContainer, "style", "display: none;"));
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
            System.out.println(dc.ZimmerSelect.get((int) (Math.random() * 10) + 1).getText());
        } else if (dc.roomName.get(randomRoom).getText().equals("Familien Suite (Dreibettzimmer)")) {
            int c = Integer.parseInt(dc.availableRoom.get(2).getText().replaceAll("[^0-9,.]", ""));
            dc.clickFunction(dc.ZimmerSelect.get((int) (Math.random() * c) + 1));
        }
    }

    @Then("The Customer verifies adult and child choices with information on the maximum number of rooms")
    public void theCustomerVerifiesAdultAndChildChoicesWithInformationOnTheMaximumNumberOfRooms() {

        int erwachseneFirstPartInt = 0;
        int erwachseneInt = 0;
        int kinderFirstPartInt = 0;
        int kinderInt = 0;
        int maximaleBelegung = 0;
        int total = 0;

        maximaleBelegung = Integer.parseInt(dc.maximaleBelegungList.get(randomRoom).getText());

        if (dc.ErwachseneText.get(randomRoom).getText().contains("+€")) {
            String erwachseneStr = dc.ErwachseneText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
            String erwachseneFirstPart = erwachseneStr.substring(0, 1);
            erwachseneFirstPartInt = Integer.parseInt(erwachseneFirstPart);

        } else {
            erwachseneInt = Integer.parseInt(dc.ErwachseneText.get(randomRoom).getText());
        }

        if (dc.KinderText.get(randomRoom).getText().contains("+€")) {
            String kinderStr = dc.KinderText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
            String kinderFirstPart = kinderStr.substring(0, 1);
            kinderFirstPartInt = Integer.parseInt(kinderFirstPart);

        } else {
            kinderInt = Integer.parseInt(dc.KinderText.get(randomRoom).getText());
        }

        total = erwachseneFirstPartInt + erwachseneInt + kinderFirstPartInt + kinderInt;
        Assert.assertTrue(maximaleBelegung >= total);


    }

    @Then("The Customer chooses the number of rooms and verify")
    public void theCustomerChoosesTheNumberOfRoomsAndVerify() {
        double erwachsenePricePartDouble = 0;
        double kinderPricePartDouble = 0;

        double roomTotalPriceText = Double.parseDouble(dc.roomTotalPrice.getText().replaceAll("[^0-9.,]", "").replace(".", "").replace(",", "."));

        if (dc.roomName.get(randomRoom).getText().equals("Einzelzimmer Standard")) {
            int textA = Integer.parseInt(dc.ZimmerText.get(0).getText());
            double priceA = Double.parseDouble(dc.roomPrice.get(0).getText().replaceAll("[^0-9,.]", "").replace(",", "."));
            double totalPriceA = (holidayDayNumber * textA * priceA);
            Assert.assertEquals(totalPriceA, roomTotalPriceText, "Total price is wrong");
        } else if (dc.roomName.get(randomRoom).getText().equals("Doppelzimmer Standard")) {
            if (dc.ErwachseneText.get(randomRoom).getText().contains("+€")) {
                String erwachseneStr = dc.ErwachseneText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
                String erwachsenePricePart = erwachseneStr.substring(1);
                erwachsenePricePartDouble = Double.parseDouble(erwachsenePricePart);
            }
            if (dc.KinderText.get(randomRoom).getText().contains("+€")) {
                String kinderStr = dc.KinderText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
                String kinderPricePart = kinderStr.substring(1);
                kinderPricePartDouble = Double.parseDouble(kinderPricePart);

            }
            int textB = Integer.parseInt(dc.ZimmerText.get(1).getText());
            double priceB = Double.parseDouble(dc.roomPrice.get(1).getText().replaceAll("[^0-9,.]", "").replace(",", "."));
            double totalPriceB = (holidayDayNumber * textB * priceB)+(erwachsenePricePartDouble*textB)+(kinderPricePartDouble*textB);
            Assert.assertEquals(totalPriceB, roomTotalPriceText, "Total price is wrong");
        } else if (dc.roomName.get(randomRoom).getText().equals("Doppelzimmer Komfort")) {
            if (dc.ErwachseneText.get(randomRoom).getText().contains("+€")) {
                String erwachseneStr = dc.ErwachseneText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
                String erwachsenePricePart = erwachseneStr.substring(1);
                erwachsenePricePartDouble = Double.parseDouble(erwachsenePricePart);
            }
            if (dc.KinderText.get(randomRoom).getText().contains("+€")) {
                String kinderStr = dc.KinderText.get(randomRoom).getText().replaceAll("[^0-9,.]", "").replace(",", ".");
                String kinderPricePart = kinderStr.substring(1);
                kinderPricePartDouble = Integer.parseInt(kinderPricePart);

            }
            int textC = Integer.parseInt(dc.ZimmerText.get(2).getText());
            double priceC = Double.parseDouble(dc.roomPrice.get(2).getText().replaceAll("[^0-9,.]", "").replace(",", "."));
            double totalPriceC = (holidayDayNumber * textC * priceC)+(erwachsenePricePartDouble* textC)+(kinderPricePartDouble* textC);
            Assert.assertEquals(totalPriceC, roomTotalPriceText, "Total price is wrong");
        } else if (dc.roomName.get(randomRoom).getText().equals("Familien Suite (Dreibettzimmer)")) {
            int textD = Integer.parseInt(dc.ZimmerText.get(3).getText());
            double priceD = Double.parseDouble(dc.roomPrice.get(3).getText().replaceAll("[^0-9,.]", "").replace(",", "."));
            double totalPriceD = (holidayDayNumber * textD * priceD);
            Assert.assertEquals(totalPriceD, roomTotalPriceText, "Total price is wrong");
        }

        System.out.println(roomTotalPriceText);


    }
    }
