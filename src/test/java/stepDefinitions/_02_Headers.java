package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DialogContent;
import pages.Headers;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _02_Headers {

    Headers hd=new Headers();
    DialogContent dc2=new DialogContent();
    ReusableMethods rm2=new ReusableMethods();
    @When("The customer clicks the Start button")
    public void theCustomerClicksTheStartButton() {
        hd.clickFunction(hd.start);
    }

    @And("The customer should see the Castle Hotel Rastatt text on the Start page")
    public void theCustomerShouldSeeTheCastleHotelRastattTextOnTheStartPage() {
        rm2.scrollToElement(dc2.txtHotelRastatt);
        Assert.assertEquals(dc2.txtHotelRastatt.getText(),"CASTLE HOTEL RASTATT");

    }

    @Then("The customer clicks Über Uns button")
    public void theCustomerClicksUberUnsButton() {
        hd.clickFunction(hd.uberUns);
    }

    @And("The customer should see the Uber Uns text on the Über Uns page")
    public void theCustomerShouldSeeTheUberUnsTextOnTheUberUnsPage() {
        Assert.assertEquals(dc2.txtUberUns.getText(),"Über uns");
    }

    @Then("The customer clicks Anfahrt button")
    public void theCustomerClicksAnfahrtButton() {
        hd.clickFunction(hd.anfahrt);
    }

    @And("The customer should see the So Fınden Sıe Uns text on the Anfahrt page")
    public void theCustomerShouldSeeTheSoFındenSıeUnsTextOnTheAnfahrtPage() {
        Assert.assertEquals(dc2.txtAnfahrt.getText(),"SO FINDEN SIE UNS");
    }

    @Then("The customer clicks Aktivitäten button")
    public void theCustomerClicksAktivitatenButton() {
        hd.clickFunction(hd.aktivitäten);
    }

    @And("The customer should see the Aktivitäten text on the Aktivitäten page")
    public void theCustomerShouldSeeTheAktivitatenTextOnTheAktivitatenPage() {
        Assert.assertEquals(dc2.txtAktivitäten.getText(),"Aktivitäten");
    }

    @Then("The customer clicks the phone number button")
    public void theCustomerClicksThePhoneNumberButton() {
        hd.clickFunction(hd.phoneNumber);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);   // ESC tuşuna bas
            robot.keyRelease(KeyEvent.VK_ESCAPE); // ESC tuşunu bırak
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("The customer clicks JETZT BUCHEN button")
    public void theCustomerClicksJETZTBUCHENButton() {
        hd.clickFunction(hd.jetztBuchenButton);
    }

    @And("The customer should be redirected to the hotel's reservation page")
    public void theCustomerShouldBeRedirectedToTheHotelSReservationPage() {
        Assert.assertEquals(dc2.txtJetztBuchen.getText(),"Check-in");
    }
}
