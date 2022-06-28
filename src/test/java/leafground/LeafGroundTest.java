package leafground;

import leafgroundpages.ElementAppearsPage;
import leafgroundpages.ElementDisappearancePage;
import leafgroundpages.TextAppearsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LeafGroundTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void WaitUntilElementDisappear(){
        ElementDisappearancePage elementDisappearPage = new ElementDisappearancePage(driver);
        elementDisappearPage.navigate();

        elementDisappearPage.waitUntilButtonDisappear();
    }

    @Test
    public void WaitUntilElementAppears(){
        ElementAppearsPage elementAppearsPage = new ElementAppearsPage(driver);
        elementAppearsPage.navigate();

        elementAppearsPage.waitUntilElementAppears();
    }

    @Test
    public void WaitUntilTextIsChanged(){
        TextAppearsPage textAppearsPage = new TextAppearsPage(driver);
        textAppearsPage.navigate();

        textAppearsPage.waitUntilTextIsChanged();
    }

}
