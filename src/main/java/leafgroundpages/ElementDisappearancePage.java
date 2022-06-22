package leafgroundpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementDisappearancePage extends LeafGeoundBasePage {

    @FindBy(xpath = "//button[@id='btn']")
    private WebElement disappearButton;

    public ElementDisappearancePage(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/disapper.html";
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get(pageUrl);
    }

    public void waitUntilButtonDisappear() {

    }

}
