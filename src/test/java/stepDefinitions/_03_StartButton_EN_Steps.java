package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Assert.assertTrue(dc.uberUnsButton.isDisplayed(), "UberUns button is not visible");
        dc.clickFunction(dc.uberUnsButton);
        Assert.assertEquals(dc.uberUnsVerify.getText(), "Über uns");
        GWD.getDriver().navigate().back();
    }

    @And("Click on the Aktivitaten uns button and verify.")
    public void clickOnTheAktivitatenUnsButtonAndVerify() {
        Assert.assertTrue(dc.aktivitaetenButton.isDisplayed(), "Aktivitaeten Button is not visible");
        dc.clickFunction(dc.aktivitaetenButton);
        Assert.assertEquals(dc.aktivitaetenVerify.getText(), "Aktivitäten");
        GWD.getDriver().navigate().back();
    }

    @Then("Navigate to the Unsere Göste sagen slideshow located below the information buttons, where user reviews are displayed, and verify.")
    public void navigateToTheUnsereGösteSagenSlideshowLocatedBelowTheInformationButtonsWhereUserReviewsAreDisplayedAndVerify() {
        List<WebElement> CommentsList = new ArrayList<>(Arrays.asList(dc.unsereGasteSagenVerify1, dc.unsereGasteSagenVerify2, dc.unsereGasteSagenVerify3));

        for (int i = 0; i < CommentsList.size(); i++) {
            dc.clickFunction(dc.unsereGasteSagenButtonList.get(i));
            dc.waitUntilVisibilityOf(CommentsList.get(i));
            System.out.println(CommentsList.get(i).getText());
            if (i == 0) {
                Assert.assertTrue(dc.unsereGasteSagenVerify1.getText().contains("Selten wurden wir bei"));
            } else if (i == 1) {
                Assert.assertTrue(dc.unsereGasteSagenVerify2.getText().contains("Das Personal war immer sehr"));
            } else if (i == CommentsList.size() - 1) {
                Assert.assertTrue(dc.unsereGasteSagenVerify3.getText().contains("Bin hetzt schon das 6"));
            }else {
                System.out.printf("Not verify Text");
            }

        }
    }
    }

