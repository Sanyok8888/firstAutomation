package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testData.User;

public class LoginPage {
    private WebDriver driver;
    private String baseUrl = "https://mail.ukr.net/";
    private By loginField = By.name("[name='login']");
    private By passwordField = By.cssSelector("[name='password']");
    private By submitButton = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){}

    public void login(User user){
        driver.findElement(loginField).sendKeys(user.getLogin());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();
    }


}
