package leafgroundpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public abstract class LeafGroundBasePage {
    protected WebDriver driver;
    protected String pageUrl;
    protected WebDriverWait webDriverWait;

    public LeafGroundBasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }


}
