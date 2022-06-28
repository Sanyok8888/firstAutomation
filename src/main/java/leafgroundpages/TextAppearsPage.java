package leafgroundpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class TextAppearsPage extends LeafGroundBasePage{

    public TextAppearsPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/TextChange.html";
        PageFactory.initElements(driver, this);
    }

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//button[@id='btn']")
    private WebElement changeTextElement;

    public void navigate() {
        driver.get(pageUrl);
    }

    public void waitUntilTextIsChanged(){
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(changeTextElement,"Click ME"));
    }

}
