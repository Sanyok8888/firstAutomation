package leafgroundpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementDisappearancePage extends LeafGroundBasePage {

    public ElementDisappearancePage(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/disapper.html";
        PageFactory.initElements(driver, this);
    }

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(xpath = "//button[@id='btn']")
    private WebElement disappearButton;

    public void navigate() {
        driver.get(pageUrl);
    }

    public void waitUntilButtonDisappear() {
        webDriverWait.until(ExpectedConditions.invisibilityOf(disappearButton));
    }

}
