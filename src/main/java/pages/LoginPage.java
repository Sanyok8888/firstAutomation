package pages;

import org.openqa.selenium.By;

public class LoginPage {
    private String baseUrl = "https://mail.ukr.net/";
    private By loginField = By.name("[name='login']");
    private By passwordField = By.cssSelector("[name='password']");
    private By submitButton = By.cssSelector("[type='submit']");
}
