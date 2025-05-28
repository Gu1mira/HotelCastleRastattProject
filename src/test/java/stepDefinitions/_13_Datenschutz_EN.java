package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.GWD;

import java.util.ArrayList;
import java.util.List;

public class _13_Datenschutz_EN {
    DialogContent dc = new DialogContent();
    List<String> datenschutzLinks=new ArrayList<>();
    @When("the user clicks on all active links")
    public void theUserClicksOnAllActiveLinks() {
        datenschutzLinks=new ArrayList<>();
        for (int i = 0; i < 84; i++) {
            dc.clickFunction(dc.datenschutzLinks);
            GWD.getDriver().navigate().back();
        }
    }

    @Then("the user verifies redirection to correct webpages")
    public void theUserVerifiesRedirectionToCorrectWebpages() {
    }
}
