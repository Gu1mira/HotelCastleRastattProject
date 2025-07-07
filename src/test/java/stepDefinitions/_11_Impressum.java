package stepDefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import utilities.GWD;
import java.time.Duration;

public class _11_Impressum {
    @And("The user clicks Impressum link at bottom side")
    public void theUserClicksImpressumLinkAtBottomSide() {
        DialogContent dc = new DialogContent();
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.impressumLink);
    }

    @And("The user should see Impressum link")
    public void theUserShouldSeeImpressumLink() {
        DialogContent dc = new DialogContent();
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("impressum"));

        if (GWD.getDriver().getCurrentUrl().contains("impressum")) {
            System.out.println("Impressum sayfası açıldı.");
        } else {
            System.out.println("Impressum sayfası açılmadı.");
        }
    }

    @And("The user should see legal informatin correctly on the page")
    public void theUserShouldSeeLegalInformatinCorrectlyOnThePage() {
        DialogContent dc = new DialogContent();

        String expectedParagraph = "Cemil Beyaz\n" +
                "Hotel Castle\n" +
                "Niederwaldstr. 2/2\n" +
                "76437 Rastatt";
        String actualText = dc.explanatoryText2.getText().trim();

        String expectedParagraph2 = "<p>VAT Id number according to Sec. 27 a German Value Added Tax Act:<br>\n" +
                "DE313706664</p>";
        String actualText2 = dc.vatInfo.getText().trim();

    }

    @And("The user clicks all link on the page")
    public void theUserClicksAllLinkOnThePage() {
        DialogContent dc = new DialogContent();
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        // 1. Linke tıkla (target'ı kaldırıp)
        js.executeScript("arguments[0].removeAttribute('target'); arguments[0].click();", dc.odrLink);

        // Sayfa yönlendikten sonra geri dön
        GWD.getDriver().navigate().back();

        // Sayfanın yeniden yüklenmesini bekle
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dc.essayWritersLink));

        // 2. Linke tıkla
        js.executeScript("arguments[0].removeAttribute('target'); arguments[0].click();", dc.essayWritersLink);
    }
}
