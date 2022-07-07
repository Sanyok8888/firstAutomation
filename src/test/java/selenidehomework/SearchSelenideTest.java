package selenidehomework;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchSelenideTestGoogleHomePage;

import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideTest {
    @BeforeClass
    public void Setup(){
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5;
    }

    @Test
    public void SearchSelenideInGoogle(){
        open("https://google.com");
        SearchSelenideTestGoogleHomePage searchSelenideTestGoogleHomePage = new SearchSelenideTestGoogleHomePage();

        searchSelenideTestGoogleHomePage.VerifyGoogleSearchFieldVisibility();
        searchSelenideTestGoogleHomePage.SetSearchText("Selenide");
        searchSelenideTestGoogleHomePage.pressEnter();
    }



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
