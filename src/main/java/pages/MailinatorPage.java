package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MailinatorPage extends BasePage {
    @FindBy(xpath = "//input[@id='search']")
    private WebElement mailinatorSearchFieldLocator;

    @FindBy(xpath = "//button[text()='GO']")
    private WebElement mailinatorGoButtonLocator;

    @FindBy(xpath = "//table[@class='table-striped jambo_table']//tbody//tr[1]")
    private WebElement lastReceivedEmailOnMailinatorLocator;

    @FindBy(xpath = "//div[@class='wrapper-info-title d-flex']//div[contains(text(),'automation1@ukr.net')]")
    private WebElement emailSenderLocator;

    @FindBy(id = "html_msg_body")
    private WebElement accessToMailinatorEmailBodyLocator;

    @FindBy(xpath = "//span[@class='xfmc1']")
    private WebElement mailinatorLetterLocator;

    @FindBy(xpath = "//div[@class='fz-20 ff-futura-demi gray-color ng-binding']")
    private WebElement mailSubjectLocator;


    public MailinatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
        PageFactory.initElements(driver,this);
    }

    public void navigate() {
        driver.get(pageUrl);
    }

    public void inputMailinatorEmail() {
        mailinatorSearchFieldLocator.sendKeys("automation1993");
    }

    public void clickGoButton() {
        mailinatorGoButtonLocator.click();
    }

    public void clickOnLastReceivedLetterOnMailinator() {
        webDriverWait.until(ExpectedConditions.visibilityOf(lastReceivedEmailOnMailinatorLocator));
        lastReceivedEmailOnMailinatorLocator.click();
    }

    public String getSenderEmail() {
        return emailSenderLocator.getText();
    }

    public String getTextFromReceivedMailOnMailinator() {
        try {
            driver.switchTo().frame(accessToMailinatorEmailBodyLocator);
            return mailinatorLetterLocator.getText();
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public String getMailSubjectText(){
        return mailSubjectLocator.getText();
    }


}
