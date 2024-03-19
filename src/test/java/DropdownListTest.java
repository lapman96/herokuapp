import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DropdownListTest extends BaseTest{
    private final String PAGE_URL = "https://the-internet.herokuapp.com/dropdown";

    private SelenideElement dropdown = $(By.id("dropdown"));
    @Test
    void checkTheAbilityToSelectOption() {
        open(PAGE_URL);
        dropdown.getSelectedOption().should(Condition.exactText("Please select an option"));
        dropdown.selectOptionByValue("1");
        dropdown.getSelectedOption().should(Condition.exactText("Option 1"));
    }
}
