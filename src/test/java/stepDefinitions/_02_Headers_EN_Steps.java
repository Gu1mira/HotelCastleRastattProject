package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DialogContent;
import pages.Headers;
import utilities.ReusableMethods;

public class _02_Headers_EN_Steps {
    Headers hd=new Headers();
    DialogContent dc2=new DialogContent();
    ReusableMethods rm2=new ReusableMethods();

    @And("The customer clicks the Home button")
    public void theCustomerClicksTheHomeButton() {
        hd.clickFunction(hd.homeBtn);

    }

    @Then("The customer should see the Castle Hotel Rastatt text on the Home page")
    public void theCustomerShouldSeeTheCastleHotelRastattTextOnTheHomePage() {
        rm2.scrollToElement(dc2.txtHotelRastattEn);
        Assert.assertEquals(dc2.txtHotelRastattEn.getText(),"HOTEL CASTLE RASTATT");
    }

    @And("The customer clicks About Us button")
    public void theCustomerClicksAboutUsButton() {
        hd.clickFunction(hd.aboutUsBtn);
    }

    @Then("The customer should see information about the hotel when they click the About Us button")
    public void theCustomerShouldSeeInformationAboutTheHotelWhenTheyClickTheAboutUsButton() {
        Assert.assertEquals(dc2.txtAboutUs.getText(),"Satellite and cable TV");

    }

    @And("The customer clicks Location button")
    public void theCustomerClicksLocationButton() {
        hd.clickFunction(hd.locationBtn);
    }

    @Then("The customer should obtain information about the hotel's location when they click the Location button")
    public void theCustomerShouldObtainInformationAboutTheHotelSLocationWhenTheyClickTheLocationButton() {
        Assert.assertEquals(dc2.txtLocation.getText().contains("located"),true);

    }

    @And("The customer clicks Activities button")
    public void theCustomerClicksActivitiesButton() {
        hd.clickFunction(hd.activitiesBtn);
    }

    @Then("The customer should see the Activities text on the Activities page")
    public void theCustomerShouldSeeTheActivitiesTextOnTheActivitiesPage() {
        Assert.assertEquals(dc2.txtOurHotel.getText().contains("Activities"), false);
    }
}
