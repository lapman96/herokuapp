import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

class CheckboxesTest extends BaseTest{
    private final String PAGE_URL = "https://the-internet.herokuapp.com/checkboxes";

    private ElementsCollection checkboxes = $$(byAttribute("type", "checkbox"));

    @Test
    void checkTheAbilityToUnselectCheckbox () {
        open(PAGE_URL);
        checkboxes.last().should(Condition.selected);
        checkboxes.last().click();
        checkboxes.last().shouldNot(Condition.selected);
    }

    @Test
    void checkTheAbilityToSelectCheckbox () {
        open(PAGE_URL);
        checkboxes.first().shouldNot(Condition.selected);
        checkboxes.first().click();
        checkboxes.first().should(Condition.selected);
    }
}
