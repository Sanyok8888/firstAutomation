package pages;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideTestGoogleHomePage {
    private static final By GOOGLE_SEARCH_FIELD = By.xpath("//input[@class='gLFyf gsfi']");
    private static final By SELENIDE_ON_SEARCH_RESULT_PAGE = By.xpath("//h3[contains(text(),'Selenide')]");
    private static final By SELENIDE_WEBSITE_HEADER = By.xpath("//h3[text()='What is Selenide?']");

    public SearchSelenideTestGoogleHomePage VerifyGoogleSearchFieldVisibility() {
        $(GOOGLE_SEARCH_FIELD).shouldBe(visible);
        return this;
    }

    public SearchSelenideTestGoogleHomePage SetSearchText(String text) {
        $(GOOGLE_SEARCH_FIELD).setValue(text);
        return this;
    }

    public SearchSelenideTestGoogleHomePage pressEnter() {
        $(GOOGLE_SEARCH_FIELD).pressEnter();
        return this;
    }

    public SearchSelenideTestGoogleHomePage FoundSelenideValues() {
        $$(SELENIDE_ON_SEARCH_RESULT_PAGE ).shouldHave(sizeGreaterThan(7));
        return this;
    }

    public SearchSelenideTestGoogleHomePage clickOnFirstLinkAfterSearch() {
        $$(SELENIDE_ON_SEARCH_RESULT_PAGE )
                .shouldHave(CollectionCondition.sizeGreaterThan(7))
                .get(0)
                .click();
        return this;
    }

    public SearchSelenideTestGoogleHomePage verifyEnteringToTheFirstLink() {
        $(SELENIDE_WEBSITE_HEADER).shouldBe(visible);
        return this;
    }


}
