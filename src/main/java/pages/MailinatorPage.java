package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MailinatorPage extends BasePage {

    private By mailinatorSearchFieldLocator = By.xpath("//input[@id='search']");
    private By mailinatorGoButtonLocator = By.xpath("//button[text()='GO']");
    private By lastReceivedEmailOnMailinatorLocator = By.xpath("//table[@class='table-striped jambo_table']//tbody//tr[1]");
    private By emailSenderLocator = By.xpath("//div[@class='wrapper-info-title d-flex']//div[contains(text(),'automation1@ukr.net')]");
    private By accessToMailinatorEmailBodyLocator = By.id("html_msg_body");
    private By mailinatorLetterLocator = By.xpath("//span[@class='xfmc1']");
    private By mailSubjectLocator = By.xpath("//div[@class='fz-20 ff-futura-demi gray-color ng-binding']");

    public MailinatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
    }


    public void navigate() {
        driver.get(pageUrl);
    }

    public void inputMailinatorEmail() {
        driver.findElement(mailinatorSearchFieldLocator).sendKeys("automation1993");

    }

    public void clickGoButton() {
        driver.findElement(mailinatorGoButtonLocator).click();
    }

    public void clickOnLastReceivedLetterOnMailinator() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastReceivedEmailOnMailinatorLocator));
        driver.findElement(lastReceivedEmailOnMailinatorLocator).click();
    }

    public String getSenderEmail() {
        return driver.findElement(emailSenderLocator).getText();
    }

    public String getTextFromReceivedMailOnMailinator() {
        try {
            driver.switchTo().frame(driver.findElement(accessToMailinatorEmailBodyLocator));
            return driver.findElement(mailinatorLetterLocator).getText();
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public String getMailSubjectText(){
        return driver.findElement(mailSubjectLocator).getText();
    }


}
