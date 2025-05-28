package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class Headers extends ReusableMethods {
    public Headers() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    //US_01_Homepage Logo

    @FindBy(xpath = "(//a[text()='Start'])[3]")
    public WebElement start;

    @FindBy(xpath = "(//a[text()='Über uns'])[3]")
    public WebElement uberUns;

    @FindBy(xpath = "(//a[text()='Anfahrt'])[3]")
    public WebElement anfahrt;

    @FindBy(xpath = "(//a[text()='Aktivitäten'])[3]")
    public WebElement aktivitäten;

    @FindBy(xpath = "(//a[text()=' 07222 1590750'])[3]")
    public WebElement phoneNumber;

    //US_08_Book_Now
    @FindBy(xpath = "(//a[text()='JETZT BUCHEN'])[3]")
    public WebElement jetztBuchenButton;


    public WebElement getWebElement(String strElementName) {

        switch (strElementName.trim()) {
            case "Jetzt Buchen":
                return this.jetztBuchenButton;

        }
        return null;
    }


}
