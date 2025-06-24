package stepDefinitions;

import io.cucumber.java.en.And;
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
}
