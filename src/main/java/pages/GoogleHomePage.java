package pages;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleHomePage extends BasePage {

    private static final By SEARCH_FIELD = By.cssSelector("[name='q']");

    public GoogleHomePage waitUntilSearchFieldDisplayed() {
        $(SEARCH_FIELD).shouldBe(visible);
        return this;
    }

    public GoogleHomePage setSearchText(String text){
        $(SEARCH_FIELD).setValue("Selenide");
        return this;
    }

    public GoogleHomePage pressEnter(){
        $(SEARCH_FIELD).pressEnter();
        return this;
    }

}
