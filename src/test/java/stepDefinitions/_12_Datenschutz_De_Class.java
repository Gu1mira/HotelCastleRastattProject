package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class _12_Datenschutz_De_Class {
    DialogContent dc = new DialogContent();
    ReusableMethods rm = new ReusableMethods();

    @Given("The user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        GWD.getDriver().get(ConfigReader.getProperty("datenschutz.link"));
    }

    @When("The user spots the Datenschutz link in the footer, clicks it")
    public void the_user_spots_the_datenschutz_link_in_the_footer_clicks_it() {
        rm.scrollToElement(dc.datenSchutzClick);
        dc.waitUntilVisibilityOf(dc.datenSchutzClick);
        dc.safeClick(dc.datenSchutzClick);
        dc.waitUntilElementToBeClickable(dc.datenSchutzClick);
    }

    @Then("The URL should contain datenschutzerklaerung")
    public void the_url_should_contain_datenschutzerklaerung() {
        String currentUrl = GWD.getDriver().getCurrentUrl();
        String homeHandle = GWD.getDriver().getWindowHandle();
        Set<String> windowsHandle = GWD.getDriver().getWindowHandles();
        for (String handle : windowsHandle) {
            if (!handle.equals(homeHandle)) {
                GWD.getDriver().switchTo().window(handle);
                dc.wait.until(ExpectedConditions.urlContains("datenschutz.link"));
                Assert.assertTrue(GWD.getDriver().getCurrentUrl().equalsIgnoreCase(ConfigReader.getProperty("datenschutz.link")));
                GWD.getDriver().switchTo().window(handle);
                break;
            }
        }
        dc.wait.until(ExpectedConditions.urlContains("datenschutz"));
        Assert.assertTrue(currentUrl.contains("datenschutz"), "Datenschutz sayfasına yönlenilmedi!");
    }

    @Then("the page headings should be verified")
    public void thePageHeadingsShouldBeVerified() {
        rm.scrollToElement(dc.headingPrivacyAtAGlance);
        rm.waitUntilVisibilityOf(dc.headingPrivacyAtAGlance);
        Assert.assertEquals(dc.headingPrivacyAtAGlance.getText(), "1. Datenschutz auf einen Blick");

        rm.scrollToElement(dc.headingGeneralInfoAndLegalNotice);
        rm.waitUntilVisibilityOf(dc.headingGeneralInfoAndLegalNotice);
        Assert.assertEquals(dc.headingGeneralInfoAndLegalNotice.getText(), "2. Allgemeine Hinweise und Pflichtinformationen");

        rm.scrollToElement(dc.headingDataCollectionOnWebsite);
        rm.waitUntilVisibilityOf(dc.headingDataCollectionOnWebsite);
        Assert.assertEquals(dc.headingDataCollectionOnWebsite.getText(), "3. Datenerfassung auf unserer Website");

        rm.scrollToElement(dc.headingSocialMedia);
        rm.waitUntilVisibilityOf(dc.headingSocialMedia);
        Assert.assertEquals(dc.headingSocialMedia.getText(), "4. Soziale Medien");

        rm.scrollToElement(dc.headingAnalyticsAndAds);
        rm.waitUntilVisibilityOf(dc.headingAnalyticsAndAds);
        Assert.assertEquals(dc.headingAnalyticsAndAds.getText(), "5. Analyse-Tools und Werbung");

        rm.scrollToElement(dc.headingPluginsAndTools);
        rm.waitUntilVisibilityOf(dc.headingPluginsAndTools);
        Assert.assertEquals(dc.headingPluginsAndTools.getText(), "6. Plugins und Tools");

        rm.scrollToElement(dc.headingPaymentProvidersAndResellers);
        rm.waitUntilVisibilityOf(dc.headingPaymentProvidersAndResellers);
        Assert.assertEquals(dc.headingPaymentProvidersAndResellers.getText(), "7. Zahlungsanbieter und Reseller");
        rm.scrollToHome();
    }

    @Then("Page links should be visible clickable accessible")
    public void page_links_should_be_visible_clickable_accessible() {
        List<WebElement> links = Arrays.asList(dc.faceBookLinks, dc.facebookPlugins, dc.instagramPrivacyLink, dc.googleGaopToutLink, dc.googleAnswerLink, dc.googleSettingsLink, dc.googlePoliciesLink, dc.googlePrivacyLink, dc.googlePrivacy2Link, dc.googlePrivacy3Link, dc.facebookPrivacyLink, dc.facebookPrivacyLink2, dc.instagramPluginLink, dc.googleBrowserPlugin, dc.googleSupportLink, dc.googleSettingsOnWeb, dc.facebookSettingsScreen, dc.yourOnlineChoices, dc.googleFonts, dc.adobePrivacy, dc.adobePolicies, dc.adobePolicy, dc.klarnaLinks, dc.klarnaLink, dc.klarnaLink2, dc.klarnaCheckout, dc.klarnaSofort, dc.sofortLink, dc.paydirektLink, dc.payLink);
        List<String> hrefs = new ArrayList<>();
        for (WebElement link : links) {
            hrefs.add(link.getAttribute("href"));
        }
        for (String href : hrefs) {
            GWD.getDriver().get(href);
            GWD.getDriver().navigate().back();
        }
    }
}