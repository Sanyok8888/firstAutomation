package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MailinatorPage extends BasePage {

    private By mailinatorSearchField = By.xpath("//input[@id='search']");
    private By mailimatorGoButton = By.xpath("//button[text()='GO']");
    private By lastReceivedEmailOnMailinator = By.xpath("//table[@class='table-striped jambo_table']//tbody//tr[1]");
    private By emailSenderLocator = By.xpath("//div[@class='wrapper-info-title d-flex']//div[contains(text(),'automation1@ukr.net')]");
    private By accessToMailinatorEmailBody = By.id("html_msg_body");
    private By mailinatorLetter = By.xpath("//span[@class='xfmc1']");

    public MailinatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
    }

    public void navigate() {
        driver.get(pageUrl);
    }

    public void inputMailinatorEmail() {
        driver.findElement(mailinatorSearchField).sendKeys("automation1993");

    }

    public void clickGoButton() {
        driver.findElement(mailimatorGoButton).click();
    }

    public void clickOnLastReceivedLetterOnMailinator() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastReceivedEmailOnMailinator));
        driver.findElement(lastReceivedEmailOnMailinator).click();
    }

    public String getSenderEmail() {
        return driver.findElement(emailSenderLocator).getText();
    }

    public String getTextFromReceivedMailOnMailinator() {
        try {
            driver.switchTo().frame(driver.findElement(accessToMailinatorEmailBody));
            return driver.findElement(mailinatorLetter).getText();
        } finally {
            driver.switchTo().parentFrame();
        }
    }


}
