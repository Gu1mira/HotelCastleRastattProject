package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;


public class DialogContent extends ReusableMethods {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

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