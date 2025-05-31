package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    // US_04_CheckInCheckOutPOM
    @FindBy(xpath = "(//*[@id='lang_sel_list']//img)[6]")
    public WebElement englishIcon;

    @FindBy(css = "[data-cli_action='accept']")
    public WebElement acceptCookies;

    @FindBy(name = "widget_date")
    public WebElement checkInWidget;

    @FindBy(name = "widget_date_to")
    public WebElement checkOutWidget;

    @FindBy(xpath = "(//*[starts-with(@class,'pika-single')])[1]//td[@data-day]")
    public List<WebElement> checkIndateList;

    @FindBy(xpath = "(//*[starts-with(@class,'pika-single')])[2]//td[@data-day]")
    public List<WebElement> checkOutdateList;

    @FindBy(xpath = "(//select[@class='pika-select pika-select-year'])[1]//option")
    public List<WebElement> checkInYearNames;

    @FindBy(xpath = "(//select[@class='pika-select pika-select-year'])[2]//option")
    public List<WebElement> checkoutYearNames;

    @FindBy(xpath = "(//select[@class='pika-select pika-select-month'])[1]//option")
    public List<WebElement> checkInMonthNames;

    @FindBy(xpath = "(//button[starts-with(@class,'pika-prev')])[1]")
    public WebElement checkInPrevButton;

    @FindBy(css = "[class='submit_link']")
    public WebElement goButton;

    @FindBy(css = "[class='hotel_name ']")
    public WebElement hotelCastleRastattText;

    @FindBy(css = "[class='message_container']")
    public List<WebElement> messageContainer;

    @FindBy(css = "[class='av-left-rooms ']")
    public List<WebElement> availableRoom;

    @FindBy(css = "[class='spinner_container']")
    public WebElement spinnerContainer;

    @FindBy(xpath = "(//select[@class='pika-select pika-select-month'])[2]//option")
    public List<WebElement> checkOutMonthNames;

    // US_12_Datenschutz_POM
    @FindBy(xpath = "//a[text()='Datenschutz']")
    public WebElement datenSchutzClick;

    @FindBy(xpath = "//div[@class='entry-content']")
    public WebElement datenschutzerklarungText;

    @FindBy(xpath = "//h2[text()='1. Datenschutz auf einen Blick']")
    public WebElement headingPrivacyAtAGlance;

    @FindBy(xpath = "//h2[text()='2. Allgemeine Hinweise und Pflichtinformationen']")
    public WebElement headingGeneralInfoAndLegalNotice;

    @FindBy(xpath = "//h2[text()='3. Datenerfassung auf unserer Website']")
    public WebElement headingDataCollectionOnWebsite;

    @FindBy(xpath = "//h2[text()='4. Soziale Medien']")
    public WebElement headingSocialMedia;

    @FindBy(xpath = "//h2[text()='5. Analyse-Tools und Werbung']")
    public WebElement headingAnalyticsAndAds;

    @FindBy(xpath = "//h2[text()='6. Plugins und Tools']")
    public WebElement headingPluginsAndTools;

    @FindBy(xpath = "//h2[text()='7. Zahlungsanbieter und Reseller']")
    public WebElement headingPaymentProvidersAndResellers;

    @FindBy(xpath = "(//a[contains(@href, '.pdf')])[2]")
    public WebElement klarnaLink2;

    @FindBy(xpath = "(//a[text()='https://www.paydirekt.de/agb/index.html'])[1]")
    public WebElement payLink;

    @FindBy(css = "a[href='https://developers.facebook.com/docs/plugins/?locale=de_DE']")
    public WebElement faceBookLinks;

    @FindBy(css = "a[href='https://de-de.facebook.com/privacy/explanation']")
    public WebElement facebookPlugins;

    @FindBy(xpath = "(//a[@href='https://instagram.com/about/legal/privacy/'])[1]")
    public WebElement instagramPrivacyLink;

    @FindBy(xpath = "//a[@href='https://tools.google.com/dlpage/gaoptout?hl=de']")
    public WebElement googleGaopToutLink;

    @FindBy(xpath = "(//a[@href='https://support.google.com/analytics/answer/6004245?hl=de'])[1]")
    public WebElement googleAnswerLink;

    @FindBy(xpath = "(//a[@href='https://www.google.com/settings/ads/onweb/'])[1]")
    public WebElement googleSettingsLink;

    @FindBy(xpath = "//a[@href='https://policies.google.com/technologies/ads?hl=de']")
    public WebElement googlePoliciesLink;

    @FindBy(xpath = "(//a[@href='https://policies.google.com/privacy?hl=de'])[1]")
    public WebElement googlePrivacyLink;

    @FindBy(xpath = "(//a[@href='https://policies.google.com/privacy?hl=de'])[2]")
    public WebElement googlePrivacy2Link;

    @FindBy(xpath = "(//a[@href='https://de-de.facebook.com/about/privacy/'])[1]")
    public WebElement facebookPrivacyLink;

    @FindBy(xpath = "(//a[@href='https://de-de.facebook.com/about/privacy/'])[2]")
    public WebElement facebookPrivacyLink2;

    @FindBy(xpath = "(//a[text()='https://instagram.com/about/legal/privacy/'])[2]")
    public WebElement instagramPluginLink;

    @FindBy(xpath = "//a[text()='https://tools.google.com/dlpage/gaoptout?hl=de']")
    public WebElement googleBrowserPlugin;

    @FindBy(xpath = "//a[text()='https://support.google.com/analytics/answer/6004245?hl=de']")
    public WebElement googleSupportLink;

    @FindBy(xpath = "(//a[text()='https://www.google.com/settings/ads/onweb/'])[1]")
    public WebElement googleSettingsOnWeb;

    @FindBy(xpath = "(//a[@href='https://www.facebook.com/ads/preferences/?entry_product=ad_settings_screen'])[1]")
    public WebElement facebookSettingsScreen;

    @FindBy(xpath = "(//a[@href='http://www.youronlinechoices.com/de/praferenzmanagement/'])[1]")
    public WebElement yourOnlineChoices;

    @FindBy(xpath = "(//a[@href='https://developers.google.com/fonts/faq'])[1]")
    public WebElement googleFonts;

    @FindBy(xpath = "(//a[@href='https://www.adobe.com/de/privacy/eudatatransfers.html'])[1]")
    public WebElement adobePrivacy;

    @FindBy(xpath = "(//a[@href='https://www.adobe.com/de/privacy/policies/typekit.html'])[1]")
    public WebElement adobePolicies;

    @FindBy(xpath = "(//a[@href='https://www.adobe.com/de/privacy/policy.html'])[1]")
    public WebElement adobePolicy;

    @FindBy(xpath = "//a[@href='https://www.klarna.com/de/datenschutz/']")
    public WebElement klarnaLinks;

    @FindBy(xpath = "(//a[@href='https://cdn.klarna.com/1.0/shared/content/policy/cookie/de_de/checkout.pdf'])[1]")
    public WebElement klarnaCheckout;

    @FindBy(xpath = "(//a[@href='https://www.sofort.de/datenschutz.html'])[1]")
    public WebElement sofortLink;

    @FindBy(xpath = "(//a[@href='https://www.klarna.com/sofort/'])[1]")
    public WebElement klarnaSofort;

    @FindBy(xpath = "(//a[@href='https://www.paydirekt.de/agb/index.html'])[1]")
    public WebElement paydirektLink;

    // US_08_JetztBuchen
    @FindBy(xpath = "(//a[text()='JETZT BUCHEN'])[3]")
    public WebElement jetztBuchenButton;

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[1]/div[1]/div[2]/div[1]/input")
    public WebElement startDatePlaceholder;

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[1]/div[2]/div[2]/div[1]/input")
    public WebElement endDatePlaceholder;

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div")
    public WebElement datePicker;

    @FindBy(css = ".day.past")
    public WebElement dayPast;

    // US06 for location

    @FindBy(xpath = "//a[text()='Anfahrt']")
    public WebElement anfahrtTab;

    @FindBy(xpath = "//div[@class='textwidget']/p")
    public WebElement explanatoryText;

    @FindBy(xpath = "//img[@alt='Englisch']")
    public WebElement englishLanguageIcon;

    By locator = By.xpath("//a[contains(@href, 'google.com/maps')]");


    public WebElement getWebElement(String strElementName) {
        switch (strElementName.trim()) {
            case "Jetzt Buchen": return jetztBuchenButton;
            case "Search Start Date": return startDatePlaceholder;
            case "Search End Date": return endDatePlaceholder;
            case "datePicker": return datePicker;
            default:
                throw new IllegalArgumentException("Element not found: " + strElementName);
        }
    }
}
