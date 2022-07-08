package selenidehomework;

import com.codeborne.selenide.CollectionCondition;
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
        searchSelenideTestGoogleHomePage.FoundSelenideValues();
        searchSelenideTestGoogleHomePage.clickOnFirstLinkAfterSearch();
        searchSelenideTestGoogleHomePage.verifyEnteringToTheFirstLink();
    }

}
