package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.locks.Condition;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void waitUntilLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.urlContains(pageUrl));
    }
}
