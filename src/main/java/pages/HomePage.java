package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

public class HomePage extends BasePage {

    private By writeLetterButton = By.xpath("//button[@class='button primary compose']");
    private By toInput = By.name("toFieldInput");
    private By subjectInput = By.name("subject");
    private By letterBody = By.id("tinymce");
    private By sendButton = By.cssSelector(".screen__head .send.button");
    private By bodyIFrame = By.cssSelector("#mce_0_ifr");
    private By letterIsSentWindow = By.cssSelector(".sendmsg__ads-ready");

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
    }

    public void clickWriteLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(writeLetterButton));
        driver.findElement(writeLetterButton).click();
    }

    public void writeLetter(String to, String subject, String body) {
        driver.findElement(toInput).sendKeys(to);
        driver.findElement(subjectInput).sendKeys(subject);
        try {
            driver.switchTo().frame(driver.findElement(bodyIFrame));
            driver.findElement(letterBody).sendKeys(body);
        } finally {
            driver.switchTo().parentFrame();
        }
    }

    public void sendLetter() {
        driver.findElement(sendButton).click();
    }

    public void letterIsSendWindowIsDispalyed() {
        driver.findElement(letterIsSentWindow).isDisplayed();
    }

//    public void letterIsSendWindowIsDispalyed() {
//        String elementTextLetter = driver.findElement(By.cssSelector(".link3")).getText();
//        String elementText = driver.findElement(By.cssSelector(".sendmsg__ads-ready")).getText();
//
//
//        System.out.println(elementText.substring(1,18));
//        webDriverWait.until(ExpectedConditions.textMatches(elementText, Pattern.compile("^Ваш лист надіслано")));
//        Assert.assertEquals(elementText.substring(1,18),"Ваш лист надіслано");
//    }

}