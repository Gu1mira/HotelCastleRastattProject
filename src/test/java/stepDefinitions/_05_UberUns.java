package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DialogContent;
import pages.Headers;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;


public class _05_UberUns {
 DialogContent dc=new DialogContent();


    @Given("Navigate to the Hotel Castle Rastatt Homepage")
    public void navigateToTheHotelCastleRastattHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));


    }

    @When("The user clicks on the Uber Uns link in the top navigation menu")
    public void theUserClicksOnTheUberUnsLinkInTheTopNavigationMenu() {
        dc.waitUntilVisibilityOf(dc.UberUnsButton);
        dc.waitUntilElementToBeClickable(dc.UberUnsButton);
        dc.safeClick(dc.UberUnsButton);

        dc.waitUntilVisibilityOf(dc.DeutschButton);
        dc.waitUntilElementToBeClickable(dc.DeutschButton);
        dc.safeClick(dc.DeutschButton);

    }

    @Then("The main content block with the title Uber Uns should be displayed")
    public void theMainContentBlockWithTheTitleUberUnsShouldBeDisplayed() {

        dc.waitUntilVisibilityOf(dc.unserHotelText);
        Assert.assertEquals(dc.unserHotelText.getText(),"UNSER HOTEL");
        Assert.assertTrue(dc.unserHotelText.isDisplayed());

        dc.waitUntilVisibilityOf(dc.uberUnsText);
        Assert.assertEquals(dc.uberUnsText.getText(),"Über uns");
        Assert.assertTrue(dc.uberUnsText.isDisplayed());

    }

    @And("The About Hotel side box should  be visible")
    public void theAboutHotelSideBoxShouldNotBeVisible() {
        dc.waitUntilVisibilityOf(dc.aboutHotel);
        Assert.assertEquals(dc.aboutHotel.getText(),"ABOUT HOTEL");
        Assert.assertTrue(dc.aboutHotel.isDisplayed());
    }

    @And("The Uber Uns titled description area and hotel photos should be displayed")
    public void theUberUnsTitledDescriptionAreaAndHotelPhotosShouldBeDisplayed() throws InterruptedException {
        dc.scrollToElement(dc.rightIcon);
        dc.waitUntilVisibilityOf(dc.rightIcon);
        dc.waitUntilElementToBeClickable(dc.rightIcon);
        dc.safeClick(dc.rightIcon);

        dc.scrollToElement(dc.leftIcon);
        dc.waitUntilVisibilityOf(dc.leftIcon);
        dc.waitUntilElementToBeClickable(dc.leftIcon);
        dc.safeClick(dc.leftIcon);




    }

}
