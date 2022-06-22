package leafgroundpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementDisappearancePage extends LeafGeoundBasePage{

    private By dissapearButton = By.xpath("//button[@id='btn']");


    public  ElementDisappearancePage(WebDriver driver){
        super(driver);
        pageUrl = "http://www.leafground.com/pages/disapper.html";
    }

    public void navigate(){
        driver.get(pageUrl);
    }

    public void waitUntilButtonDisappear(){

    }

}
