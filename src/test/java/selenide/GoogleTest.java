package selenide;

import com.codeborne.selenide.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class GoogleTest {

    @BeforeClass
    public void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 4;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void userShouldSearch() {
        open("https://google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.waitUntilSearchFieldDisplayed();
        googleHomePage.setSearchText("Selenide");
        googleHomePage.pressEnter();

//        SelenideElement searchField = $("[name='q']");


//        $("[name='q']")
//                .shouldBe(visible)
//                .setValue("Selenide").pressEnter()
//                .pressEnter();
//        $$x("//h3[contains(text(), 'Selenide')]")
//                .filter(visible)
//                .shouldHave(sizeGreaterThanOrEqual(7))
//                .get(0)
//                .click();
//        $(".donate_header")
//                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));

    }
}
