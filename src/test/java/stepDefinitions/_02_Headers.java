package stepDefinitions;

import io.cucumber.java.en.When;
import pages.Headers;

public class _02_Headers {

    Headers hd=new Headers();
    @When("The customer clicks the Start button")
    public void theCustomerClicksTheStartButton() {
        hd.clickFunction(hd.start);
    }
}
