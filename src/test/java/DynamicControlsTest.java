import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class DynamicControlsTest extends BaseTest{
    private final String PAGE_URL = "https://the-internet.herokuapp.com/dynamic_controls";

    private SelenideElement checkboxe = $(byId("checkbox"));
    private SelenideElement removeButton = $(byText("Remove"));
    private SelenideElement inputField = $(byAttribute("type", "text"));
    private SelenideElement enableButton = $(byText("Enable"));

    @Test
    void checkThatInputFieldIsDisabled() {
        open(PAGE_URL);
        inputField.should(Condition.disabled);
    }

    @Test
    void checkTheAbilityToEnableInputField() {
        open(PAGE_URL);
        enableButton.click();
        inputField.should(Condition.enabled);
    }

    @Test
    void checkTheAbilityToHideCheckbox() {
        open(PAGE_URL);
        checkboxe.should(Condition.visible);
        removeButton.click();
        checkboxe.shouldNot(Condition.visible);
    }

}
