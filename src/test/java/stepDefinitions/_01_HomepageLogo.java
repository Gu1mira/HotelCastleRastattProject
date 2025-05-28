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

public class _01_HomepageLogo {

    DialogContent dc=new DialogContent();
    Headers hs=new Headers();
    String currentUrl= GWD.getDriver().getCurrentUrl();

    @When("the user clicks on the German language button")
    public void theUserClicksOnTheGermanLanguageButton() {
        //GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        dc.clickFunction(dc.germanIcon);
    }

    @And("the user clicks on the headers and clicks on Homepage Logo")
    public void theUserClicksOnTheHeadersAndClicksOnHomepageLogo() {
        hs.clickFunction(hs.start);
        dc.clickFunction(dc.homepageLogo);
        hs.clickFunction(hs.uberUns);
        dc.clickFunction(dc.homepageLogo);
        hs.clickFunction(hs.anfahrt);
        dc.clickFunction(dc.homepageLogo);
        hs.clickFunction(hs.aktivitäten);
        dc.clickFunction(dc.homepageLogo);
    }

    @Then("the user confirms redirection to the homepage")
    public void theUserConfirmsRedirectionToTheHomepage() {
        Assert.assertEquals(currentUrl,"https://hotel-castle-rastatt.de/");
    }

}
