package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DialogContent;
import pages.Headers;

public class _07_Activities {
    Headers hd=new Headers();
    DialogContent dc=new DialogContent();

    @When("The customer clicks on the Aktivitaten button in the header menu")
    public  void theCustomerclicksontheAktivitatenbutton(){
        hd.clickFunction(hd.aktivitäten);
    }

    @And("Verify the Aktivitaten page")
    public void verifyAktivitatenpage(){
        dc.verifyContainsText(dc.aktivitaetenVerify, "Aktivitäten");
    }

    @When("The customer clicks on the Activities button in the header menu")
    public  void theCustomerclicksontheActivitiesbutton(){
        hd.clickFunction(hd.aktivitäten);
    }

    @And("Verify the Activities page")
    public void verifyActivitiespage(){
        dc.verifyContainsText(dc.aktivitaetenVerify, "Activities");
    }


}
