import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest {
    private String baseUrl = "http://www.leafground.com/pages/checkbox.html";

    By languageBlockCheckBoxLocator = By.xpath("//div[@class='example'][1]//input[@type='checkbox'][1]");
    By confirmSeleniumIsCheckedCheckboxLocator = By.xpath("//div[@class='example'][2]//input[@type='checkbox'][1]");
    By deselectOnlyCheckedBlockCheckboxLocator = By.xpath("//div[@class='example'][3]//input[@type='checkbox'][2]");
    By selectAllBelowCheckboxesBlockLocator = By.xpath("//div[@class='example']/label[@for='java'] [text()='Select all below checkboxes ']/following-sibling::input");

    WebElement languageBlockCheckBox;
    WebElement confirmSeleniumIsCheckedBlockCheckbox;
    WebElement deselectOnlyCheckedBlockCheckbox;
    List selectAllBelowCheckboxes;

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver.get(baseUrl);

        languageBlockCheckBox = driver.findElement(languageBlockCheckBoxLocator);
        confirmSeleniumIsCheckedBlockCheckbox = driver.findElement(confirmSeleniumIsCheckedCheckboxLocator);
        deselectOnlyCheckedBlockCheckbox = driver.findElement(deselectOnlyCheckedBlockCheckboxLocator);
        selectAllBelowCheckboxes = driver.findElements(selectAllBelowCheckboxesBlockLocator);
    }

    @Test
    public void selectLanguageBlockCheckboxTest() {
        languageBlockCheckBox.click();
        Assert.assertTrue(languageBlockCheckBox.isSelected());
    }

    @Test
    public void checkConfirmSeleniumIsCheckedCheckboxTest() {
        Assert.assertTrue(confirmSeleniumIsCheckedBlockCheckbox.isSelected());
    }

    @Test
    public void checkDeselectOnlyCheckedCheckboxTest() {
        deselectOnlyCheckedBlockCheckbox.click();
        Assert.assertFalse(deselectOnlyCheckedBlockCheckbox.isSelected());
    }

    @Test
    public void selectAllBelowCheckboxesTest() {
        List<WebElement> checkboxesList = selectAllBelowCheckboxes;
        for (WebElement checkbox : checkboxesList) {
            checkbox.click();
        }
        for (WebElement checkbox : checkboxesList) {
            checkbox.isSelected();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

