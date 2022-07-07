package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchSelenideTestGoogleHomePage {
    private static final By GOOGLE_SEARCHFIELD = By.xpath("//input[@class='gLFyf gsfi']");

    public SearchSelenideTestGoogleHomePage VerifyGoogleSearchFieldVisibility(){
        $(GOOGLE_SEARCHFIELD).shouldBe(visible);
        return this;
    }

    public SearchSelenideTestGoogleHomePage SetSearchText(String text){
        $(GOOGLE_SEARCHFIELD).setValue(text);
        return this;
    }

    public SearchSelenideTestGoogleHomePage pressEnter(){
        $(GOOGLE_SEARCHFIELD).pressEnter();
        return this;
    }
}
