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

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User("automation1@ukr.net", "ytrewq1234");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        MailinatorPage mailinatorPage = new MailinatorPage(driver);

        homePage.clickWriteLetter();
        homePage.writeLetter("automation1993@mailinator.com", "qwerty", "test body");
        homePage.sendLetter();
        homePage.letterIsSendWindowIsDispalyed();
        mailinatorPage.navigate();
        mailinatorPage.inputMailinatorEmail();
        mailinatorPage.clickGoButton();
        mailinatorPage.clickOnLastReceivedLetterOnMailinator();
        Assert.assertEquals("automation1@ukr.net", mailinatorPage.getSenderEmail());
        Assert.assertEquals("test body", mailinatorPage.getTextFromReceivedMailOnMailinator());

    }

}






















