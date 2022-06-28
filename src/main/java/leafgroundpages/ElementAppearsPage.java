package leafgroundpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementAppearsPage extends LeafGroundBasePage{

    @FindBy(xpath = "//button[@id='btn']//b")
    private WebElement appearsElement;

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ElementAppearsPage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/appear.html";
        PageFactory.initElements(driver, this);
    }

    public void navigate(){driver.get(pageUrl);}

    public void waitUntilElementAppears(){
        webDriverWait.until(ExpectedConditions.visibilityOf(appearsElement));
    }


}
