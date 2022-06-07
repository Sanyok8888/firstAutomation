package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import testData.User;

public class UkrNetTest {
private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void sendEmailToMailinatorTest(){
        User user = new User("automation1@ukr.net","ytrewq1234");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
    }
}
