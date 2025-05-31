package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class _03_StartButton_EN_Steps {

    DialogContent dc = new DialogContent();

    @Given("Navigate to the hotel castle rastatt")
    public void navigateToTheHotelCastleRastatt() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @And("Click and verify the English language button located in the top right corner of the page.")
    public void clickAndVerifyTheEnglishLanguageButtonLocatedInTheTopRightCornerOfThePage() {
        Assert.assertTrue(dc.englishButton.isDisplayed(), "English button is not visible");
        dc.clickFunction(dc.englishButton);
    }

    @When("Navigate to the slideshow function located at the top of the website and verify.")
    public void navigateToTheSlideshowFunctionLocatedAtTheTopOfTheWebsiteAndVerify() {
        Assert.assertTrue(dc.slideShow.isDisplayed(),"SlideShow is not visible");
    }

    @And("Click on the left arrow button and verify.")
    public void clickOnTheLeftArrowButtonAndVerify() {
        dc.clickFunction(dc.slideShowLeftButton);
        Assert.assertTrue(dc.slideShowLeftButton.isDisplayed(), "SlideShow left button is not visible");
    }

    @And("Click on the right arrow button and verify.")
    public void clickOnTheRightArrowButtonAndVerify() {
        Assert.assertTrue(dc.slideShowRightButton.isDisplayed(), "SlideShow right button is not visible");
        dc.clickFunction(dc.slideShowRightButton);
    }

    @When("Navigate to the gretting text located under the slideshow function and verify.")
    public void navigateToTheGrettingTextLocatedUnderTheSlideshowFunctionAndVerify() {
        Assert.assertEquals(dc.greetingText.getText(), "WILLKOMMEN BEIM");
    }

    @And("Click on the Anfahrt button and verify.")
    public void clickOnTheAnfahrtButtonAndVerify() {
        Assert.assertTrue(dc.anfahrtButton.isDisplayed(), "Anfahrt button is not visible");
        dc.clickFunction(dc.anfahrtButton);
        Assert.assertEquals(dc.anfahrtVerify.getText(), "SO FINDEN SIE UNS");
        GWD.getDriver().navigate().back();
    }

    @And("Click on the Über uns button and verify.")
    public void clickOnTheÜberUnsButtonAndVerify() {
    }

    @And("Click on the Aktivitaten uns button and verify.")
    public void clickOnTheAktivitatenUnsButtonAndVerify() {
    }

    @Then("Navigate to the Unsere Göste sagen slideshow located below the information buttons, where user reviews are displayed, and verify.")
    public void navigateToTheUnsereGösteSagenSlideshowLocatedBelowTheInformationButtonsWhereUserReviewsAreDisplayedAndVerify() {
    }
}
