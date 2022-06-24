package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MailinatorPage;
import testdata.User;

public class UkrNetTest {

    private WebDriver driver;
    private String senderEmail = "automation1@ukr.net";
    private String senderEmailPassword = "ytrewq1234";
    private String receiverMailinatorEmail =  "automation1993@mailinator.com";
    private String mailText = "test body";
    private String mailSubject = "qwerty";

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User(senderEmail, senderEmailPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        MailinatorPage mailinatorPage = new MailinatorPage(driver);

        homePage.clickWriteLetter();
        homePage.writeLetter(receiverMailinatorEmail, mailSubject, mailText);
        homePage.sendLetter();
        homePage.letterIsSendWindowIsDispalyed();
        mailinatorPage.navigate();
        mailinatorPage.inputMailinatorEmail();
        mailinatorPage.clickGoButton();
        mailinatorPage.clickOnLastReceivedLetterOnMailinator();
        Assert.assertEquals(mailSubject, mailinatorPage.getMailSubjectText());
        Assert.assertEquals(senderEmail, mailinatorPage.getSenderEmail());
        Assert.assertEquals(mailText, mailinatorPage.getTextFromReceivedMailOnMailinator());

    }




}






















