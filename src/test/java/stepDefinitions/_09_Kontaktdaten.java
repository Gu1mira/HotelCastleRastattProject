package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;


public class _09_Kontaktdaten {

    DialogContent element=new DialogContent();




    @Then("The booking details on the information filling screen must match the selected details")
    public void theBookingDetailsOnTheInformationFillingScreenMustMatchTheSelectedDetails() {
    }

    @And("The user fills in the information required for the booking")
    public void theUserFillsInTheInformationRequiredForTheBooking() {
        element.wait.until(ExpectedConditions.urlContains("reservation"));
        element.getCurrentURL().contains("reservation");

        if (element.kasseText.isDisplayed()) {
            element.verifyContainsText(element.kasseText,"KASSE");

            ConfigReader.updateProperty("firstname");
            element.sendKeysFunction(element.firstName,ConfigReader.getProperty("firstname"));
            ConfigReader.updateProperty("lastname");
            element.sendKeysFunction(element.lastname,ConfigReader.getProperty("lastname"));
            ConfigReader.updateProperty("email");
            element.sendKeysFunction(element.email,ConfigReader.getProperty("email"));
            ConfigReader.updateProperty("phone");
            element.sendKeysFunction(element.phone,ConfigReader.getProperty("phone"));

            element.selectMenu(element.selectCountryMenu,element.selectCountry);

            ConfigReader.updateProperty("postalCode");
            element.sendKeysFunction(element.postalCode,ConfigReader.getProperty("postalCode"));
            ConfigReader.updateProperty("address1");
            element.sendKeysFunction(element.address1,ConfigReader.getProperty("address1"));
            ConfigReader.updateProperty("address2");
            element.sendKeysFunction(element.address2,ConfigReader.getProperty("address2"));
            ConfigReader.updateProperty("city");
            element.sendKeysFunction(element.city,ConfigReader.getProperty("city"));

            element.selectMenu(element.selectStateMenu, element.selectState);

            ConfigReader.updateProperty("guestName");
            element.sendKeysFunction(element.guestName,ConfigReader.getProperty("guestName"));
            ConfigReader.updateProperty("orderNumber");
            element.sendKeysFunction(element.orderNumber,ConfigReader.getProperty("orderNumber"));
            ConfigReader.updateProperty("vatID");
            element.sendKeysFunction(element.vatID,ConfigReader.getProperty("vatID"));
            ConfigReader.updateProperty("costCenter");
            element.sendKeysFunction(element.costCenter,ConfigReader.getProperty("costCenter"));
            ConfigReader.updateProperty("reference");
            element.sendKeysFunction(element.reference,ConfigReader.getProperty("reference"));

        }

    }

    @Then("User clicks the confirmation button and verifies the confirmation message")
    public void userClicksTheConfirmationButtonAndVerifiesTheConfirmationMessage() {
        element.wait.until(ExpectedConditions.visibilityOf(element.acceptTextControl));
        element.verifyContainsText(element.acceptTextControl,"Ich stimme den");
        element.clickFunction(element.agreeTermsCheckBox);
        element.clickFunction(element.rezervationBtn);



    }
}
