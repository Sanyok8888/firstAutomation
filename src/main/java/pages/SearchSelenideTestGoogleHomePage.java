package pages;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideTestGoogleHomePage {
    private static final By GOOGLE_SEARCHFIELD = By.xpath("//input[@class='gLFyf gsfi']");
    private static final By SELENIDE_ON_SEARCHPAGE = By.xpath("//a//h3[contains(text(),'Selenide')]");

    public SearchSelenideTestGoogleHomePage VerifyGoogleSearchFieldVisibility() {
        $(GOOGLE_SEARCHFIELD).shouldBe(visible);
        return this;
    }

    public SearchSelenideTestGoogleHomePage SetSearchText(String text) {
        $(GOOGLE_SEARCHFIELD).setValue(text);
        return this;
    }

    public SearchSelenideTestGoogleHomePage pressEnter() {
        $(GOOGLE_SEARCHFIELD).pressEnter();
        return this;
    }

    public SearchSelenideTestGoogleHomePage FoundSelenideValues() {
        $$(SELENIDE_ON_SEARCHPAGE).shouldHave(sizeGreaterThan(7));
        return this;
    }

    public SearchSelenideTestGoogleHomePage clickOnFirstLinkAfterSearch() {
        $$(SELENIDE_ON_SEARCHPAGE)
                .shouldHave(CollectionCondition
                .sizeGreaterThan(7))
                .get(0)
                .click();
        return this;
    }



}
