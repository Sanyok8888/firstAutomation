package leafground;

import leafgroundpages.ElementDisappearancePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeafGroundTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void WaitUntilElementDisappear(){
        ElementDisappearancePage ElementDisappearPage = new ElementDisappearancePage(driver);
        ElementDisappearPage.navigate();

    }

}
