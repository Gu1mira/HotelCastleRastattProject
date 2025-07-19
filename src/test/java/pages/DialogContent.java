package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.security.cert.X509Certificate;
import java.util.List;


public class DialogContent extends ReusableMethods {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    //US_04_CheckInCheckOutPOM
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

    @FindBy(css = "[class='av-left-rooms '] ")
    public List<WebElement> availableRoom;

    @FindBy(css = "[class='spinner_container']")
    public WebElement spinnerContainer;

    @FindBy(xpath = "(//select[@class='pika-select pika-select-month'])[2]//option")
    public List<WebElement> checkOutMonthNames;

    //stepDefinitions._09_Kontaktdaten
    @FindBy(xpath = "//*[text()='Kasse']")
    public WebElement kasseText;

    @FindBy(css = "[id='first_name']")
    public WebElement firstName;

    @FindBy(css = "[id='last_name']")
    public WebElement lastname;

    @FindBy(css = "[id='email']")
    public WebElement email;

    @FindBy(css = "[id='phone']")
    public WebElement phone;

    @FindBy(css = "[id='country']")
    public WebElement selectCountryMenu;

    @FindBy(xpath = "//select[@id='country']//option")
    public List<WebElement> selectCountry;

    @FindBy(css = "[id='zip']")
    public WebElement postalCode;

    @FindBy(css = "[id='address1']")
    public WebElement address1;

    @FindBy(css = "[id='address2']")
    public WebElement address2;

    @FindBy(css = "[id='city']")
    public WebElement city;

    @FindBy(css = "[id='state']")
    public WebElement selectStateMenu;

    @FindBy(xpath = "//select[@id='state']//option")
    public List<WebElement> selectState;

    @FindBy(css = "[data-label='Gastname']")
    public WebElement guestName;

    @FindBy(css = "[data-label='Auftragsnummer']")
    public WebElement orderNumber;

    @FindBy(css = "[data-label='VAT ID']")
    public WebElement vatID;

    @FindBy(css = "[data-label='Kostenstelle']")
    public WebElement costCenter;

    @FindBy(css = "[title='reference']")
    public WebElement reference;

    @FindBy(linkText = "Ich stimme den")
    public WebElement acceptTextControl;

    @FindBy(xpath = "//label[@for='agree_terms']/span[@class='box']")
    public WebElement agreeTermsCheckBox;

    @FindBy(xpath = "//*[text()='Reservierung abschließen']")
    public WebElement rezervationBtn;


    //_12_Datenschutz_POM
    @FindBy(xpath = "//a[text()='Datenschutz']")
    public WebElement datenSchutzClick;

    @FindBy(xpath = "//div[@class='entry-content']")
    public WebElement datenschutzerklarungText;

    @FindBy(xpath = "//h2[text()='1. Datenschutz auf einen Blick']")   //1
    public WebElement headingPrivacyAtAGlance;

    @FindBy(xpath = "//h2[text()='2. Allgemeine Hinweise und Pflichtinformationen']")  //2
    public WebElement headingGeneralInfoAndLegalNotice;

    @FindBy(xpath = "//h2[text()='3. Datenerfassung auf unserer Website']")  //3
    public WebElement headingDataCollectionOnWebsite;

    @FindBy(xpath = "//h2[text()='4. Soziale Medien']")         //4
    public WebElement headingSocialMedia;

    @FindBy(xpath = "//h2[text()='5. Analyse-Tools und Werbung']")  //5
    public WebElement headingAnalyticsAndAds;

    @FindBy(xpath = "//h2[text()='6. Plugins und Tools']")     //6
    public WebElement headingPluginsAndTools;

    @FindBy(xpath = "//h2[text()='7. Zahlungsanbieter und Reseller']") //7
    public WebElement headingPaymentProvidersAndResellers;

    @FindBy(css = "a[href='https://www.klarna.com/de/datenschutz/']")
    public WebElement klarnaLink;

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

    @FindBy(xpath = "(//a[@href='https://policies.google.com/privacy?hl=de'])[1]")
    public WebElement googlePrivacy3Link;

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

    @FindBy(xpath = "(//a[@href='https://www.paydirekt.de/agb/index.html'])")
    public WebElement paydirektLink;

    //US_08_JetztBuchen
    @FindBy(xpath = "(//a[text()='JETZT BUCHEN'])[3]")
    public WebElement jetztBuchenButton;

//    @FindBy(xpath = "input[placeholder='-']")
//    List<WebElement> placeholders;
//    public WebElement startDatePlaceholder = placeholders.get(0);
//    public WebElement endDatePlaceholder = placeholders.get(1);

    // WARNING!
    // ⚠️ WebElement'leri constructor dışında List.get(0) gibi ifadelerle doğrudan initialize etme.
    // Çünkü @FindBy anotasyonları PageFactory.initElements() çağrılmadan önce çalışmaz.

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[1]/div[1]/div[2]/div[1]/input")
    public WebElement startDatePlaceholder;

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[1]/div[2]/div[2]/div[1]/input")
    public WebElement endDatePlaceholder;

    @FindBy(css = "div.calendar-container")
    public WebElement datePicker;

    @FindBy(xpath = "//div[contains(@class,'day') and not(contains(@class,'disabled'))]//p")
    public List<WebElement> enabledDays;  // Seçilebilir günlerin <p> tag'larındaki sayılar

    @FindBy(css = "div.day.endDate.ui-state-checkout")
    public WebElement selectedDay;

    @FindBy(xpath = "//*[@id='rooms-search-form']/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div[2]")
    public WebElement arrow;

    // _02_Headers sayfa içi POM

    @FindBy(xpath = "//h3[text()='CASTLE HOTEL RASTATT']")
    public WebElement txtHotelRastatt;

    @FindBy(xpath = "//h2[text()='Über uns']")
    public WebElement txtUberUns;

    @FindBy(xpath = "//h3[text()='SO FINDEN SIE UNS']")
    public WebElement txtAnfahrt;

    @FindBy(xpath = "//h3[text()='Aktivitäten']")
    public WebElement txtAktivitäten;

    @FindBy(xpath = "//p[text()='Check-in']")
    public WebElement txtJetztBuchen;

    @FindBy(xpath = "//h3[text()='HOTEL CASTLE RASTATT']")
    public WebElement txtHotelRastattEn;

    @FindBy(xpath = "//li[text()='Satellite and cable TV']")
    public WebElement txtAboutUs;

    @FindBy(xpath = "//p[contains(text(), 'located')]")
    public WebElement txtLocation;

    @FindBy(xpath = "//h3[text()='OUR HOTEL']")
    public WebElement txtOurHotel;




    @FindBy(xpath = "(//*[@id='lang_sel_list']//li//img)[5]")
    public WebElement germanIcon;

    @FindBy(css = "img.logo")
    public WebElement homepageLogo;

    @FindBy(xpath = "//a")
    public WebElement datenschutzLinks;


    //US_003_StartButton

    @FindBy(css = "div[class='inner-navigation'] ul img[alt='Englisch']")
    public WebElement englishButton;
    @FindBy(css = "[data-source=gallery]")
    public WebElement slideShow;
    @FindBy(css = "[style='opacity: 1; transform: translate(30px, -35px); top: 50%; left: 0px;']")
    public WebElement slideShowLeftButton;
    @FindBy(css = "[style='opacity: 1; transform: translate(-100px, -35px); top: 50%; left: 100%;']")
    public WebElement slideShowRightButton;
    @FindBy(xpath = "//p[text()='WILLKOMMEN BEIM']")
    public WebElement greetingText;
    @FindBy(css = "[href='https://hotel-castle-rastatt.de/anfahrt']")
    public WebElement anfahrtButton;
    @FindBy(xpath = "//h3[text()='SO FINDEN SIE UNS']")
    public WebElement anfahrtVerify;
    @FindBy(css = "[href='https://hotel-castle-rastatt.de/ueber-uns']")
    public WebElement uberUnsButton;
    @FindBy(xpath = "//h2[text()='Über uns']")
    public WebElement uberUnsVerify;
    @FindBy(css = "[href='https://hotel-castle-rastatt.de/aktivitaeten']")
    public WebElement aktivitaetenButton;
    @FindBy(xpath = "//h3[text()='Aktivitäten']")
    public WebElement aktivitaetenVerify;
    @FindBy(xpath = "(//div[@class='testimonial-content']) [3]")
    public WebElement unsereGasteSagenVerify1;
    @FindBy(xpath = "(//div[@class='testimonial-content']) [4]")
    public WebElement unsereGasteSagenVerify2;
    @FindBy(xpath = "(//div[@class='testimonial-content']) [5]")
    public WebElement unsereGasteSagenVerify3;
    @FindBy(css = "[class='owl-dots'] div")
    public List<WebElement> unsereGasteSagenButtonList;

    //US_005_UberUns
    @FindBy(xpath ="(//*[@id='lang_sel_list']//img)[5]" )
    public WebElement DeutschButton;
    @FindBy (xpath = "(//a[text()='Über uns'])[3]")
    public WebElement UberUnsButton;
    @FindBy (xpath = "//span[@class='icon-prev']")
    public WebElement leftIcon;
    @FindBy(xpath = "//a[@class='vc_left vc_carousel-control']")
    public WebElement rightIcon;
    @FindBy(xpath = "//h3[text()='UNSER HOTEL']")
    public WebElement unserHotelText;
    @FindBy (xpath = "//h2[text()='Über uns']")
    public WebElement uberUnsText;
    @FindBy (xpath = "//h3[text()='About Hotel']")
    public  WebElement aboutHotel;

    public WebElement getWebElement(String strElementName) {

        switch (strElementName.trim()) {
            case "Jetzt Buchen":
                return this.jetztBuchenButton;
            case "Search Start Date":
                return this.startDatePlaceholder;
            case "Search End Date":
                return this.endDatePlaceholder;
            case "datePicker":
                return this.datePicker;

        }
        return null;
    }

    //US_14_DE_HOTEL_ROOM_SELECTION_AND_BOOKİNG_PROCESS

    @FindBy(xpath = "//*[text()='Suchen']")
    public WebElement suchenButton;
    @FindBy(css="[name='search_start_date']")
    public WebElement checkInPLc;
    @FindBy(css="[name='search_end_date']")
    public WebElement checkOutPLc;
    @FindBy(css = "[class=\"av_wrapper\"]:not([style*='display: none']) [aria-label*=\"Maximale Belegung\"]")
    public List<WebElement> maximaleBelegungList;
    @FindBy(css="[class=\"av-room-options\"] [class=\"btn-group bootstrap-select adults_select\"]")
    public List<WebElement> ErwachseneList;
    @FindBy(css="[class=\"av-room-options\"] [class=\"btn-group bootstrap-select children_select\"]")
    public List<WebElement> KinderList;
    @FindBy(css="[class=\"btn-group bootstrap-select rooms_select\"] [class=\"filter-option pull-left\"]")
    public List<WebElement> ZimmerList;
    @FindBy(css="[class=\"btn-group bootstrap-select adults_select open\"] [class=\"text\"]")
    public List<WebElement> ErwachseneSelect;
    @FindBy(css="[class=\"btn-group bootstrap-select children_select open\"] [class=\"text\"]")
    public List<WebElement> KinderSelect;
    @FindBy(css="[class=\"btn-group bootstrap-select rooms_select open\"] [class=\"text\"]")
    public List<WebElement> ZimmerSelect;
    @FindBy(css="[class=\"btn-group bootstrap-select children_select\"] [class=\"filter-option pull-left\"]")
    public List<WebElement> KinderText;
    @FindBy(css="[class=\"btn-group bootstrap-select adults_select\"] [class=\"filter-option pull-left\"]")
    public List<WebElement> ErwachseneText;
    @FindBy(css="[class=\"btn-group bootstrap-select rooms_select\"] [class=\"filter-option pull-left\"]")
    public List<WebElement> ZimmerText;
    @FindBy(css="[class=\"av-name\"]:not([aria-label*=\"Economy\"])")
    public List<WebElement> roomName;
    @FindBy(css="[class=\"av-rate-price \"]")
    public List<WebElement>roomPrice;
    @FindBy(css="[class='selected_rooms_price']")
    public WebElement roomTotalPrice;



}